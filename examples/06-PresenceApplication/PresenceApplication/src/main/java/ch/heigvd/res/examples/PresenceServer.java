package ch.heigvd.res.examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class is a multi-threaded server of the custom presence protocol. The
 * server binds a socket on the specified port and waits for incoming connection
 * requests. It keeps track of connected clients in a list. When new clients
 * arrive, leave or send messages, the server notifies all connected clients.
 *
 * @author Olivier Liechti
 */
public class PresenceServer implements Runnable {

	final static Logger LOG = Logger.getLogger(PresenceServer.class.getName());

	boolean shouldRun;
	ServerSocket serverSocket;
	final List<Worker> connectedWorkers;

	public PresenceServer() {
		this.shouldRun = true;
		this.connectedWorkers = Collections.synchronizedList(new LinkedList<Worker>());
	}

	private void registerWorker(Worker worker) {
		LOG.log(Level.INFO, ">> Waiting for lock before registring worker {0}", worker.userName);
		connectedWorkers.add(worker);
		LOG.log(Level.INFO, "<< Worker {0} registered.", worker.userName);
	}

	private void unregisterWorker(Worker worker) {
		LOG.log(Level.INFO, ">> Waiting for lock before unregistring worker {0}", worker.userName);
		connectedWorkers.remove(worker);
		LOG.log(Level.INFO, "<< Worker {0} unregistered.", worker.userName);
	}

	private void notifyConnectedWorkers(String message) {
		LOG.info(">> Waiting for lock before notifying workers");
		synchronized (connectedWorkers) {
		LOG.info("Notifying workers");
			for (Worker worker : connectedWorkers) {
				worker.sendNotification(message);
			}
		}
		LOG.info("<< Workers notified");
	}

	private void disconnectConnectedWorkers() {
		LOG.info(">> Waiting for lock before disconnecting workers");
		synchronized (connectedWorkers) {
		LOG.info("Disconnecting workers");
			for (Worker worker : connectedWorkers) {
				worker.disconnect();
			}
		}
		LOG.info("<< Workers disconnected");
	}

	@Override
	public void run() {
		try {
			LOG.log(Level.INFO, "Starting Presence Server on port {0}", Protocol.PRESENCE_DEFAULT_PORT);
			serverSocket = new ServerSocket(Protocol.PRESENCE_DEFAULT_PORT);
			while (shouldRun) {
				Socket clientSocket = serverSocket.accept();
				PresenceServer.this.notifyConnectedWorkers("Someone has arrived...");
				Worker newWorker = new Worker(clientSocket);
				registerWorker(newWorker);
				new Thread(newWorker).start();
			}
			serverSocket.close();
			LOG.info("shouldRun is false... server going down");
		} catch (IOException ex) {
			LOG.log(Level.SEVERE, ex.getMessage(), ex);
            System.exit(-1);
		}
	}

	private void shutdown() {
		LOG.info("Shutting down server...");
		shouldRun = false;
		try {
			serverSocket.close();
		} catch (IOException ex) {
			LOG.log(Level.SEVERE, ex.getMessage(), ex);
		}
		disconnectConnectedWorkers();
	}

	class Worker implements Runnable {

		Socket clientSocket;
		BufferedReader in;
		PrintWriter out;
		boolean connected;
		String userName = "An anonymous user";

		public Worker(Socket clientSocket) {
			this.clientSocket = clientSocket;
			try {
				in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				out = new PrintWriter(clientSocket.getOutputStream());
				connected = true;
			} catch (IOException ex) {
				LOG.log(Level.SEVERE, ex.getMessage(), ex);
			}
		}

		@Override
		public void run() {
			String commandLine;
			PresenceServer.this.notifyConnectedWorkers("Welcome to the Presence Server");
			PresenceServer.this.notifyConnectedWorkers("  Tell me who you are with 'HELLO name'");
			PresenceServer.this.notifyConnectedWorkers("  Say something to other users with 'SAY message'");
			PresenceServer.this.notifyConnectedWorkers("  Ask me who is connected with 'WHO'");
			PresenceServer.this.notifyConnectedWorkers("  Leave with 'BYE'");
			PresenceServer.this.notifyConnectedWorkers("  Shutdown server with 'KILL'");
			try {
				while (connected && ((commandLine = in.readLine()) != null)) {
					String[] tokens = commandLine.split(" ");
					switch (tokens[0].toUpperCase()) {
						case (Protocol.CMD_HELLO):
							userName = tokens.length >= 2 ? tokens[1] : "An anonymous user";
							PresenceServer.this.notifyConnectedWorkers(userName + " is in the room.");
							break;
						case (Protocol.CMD_SAY):
							String message = tokens.length >= 2 ? commandLine.substring(4) : "nothing...";
							PresenceServer.this.notifyConnectedWorkers(userName + " says: " + message);
							break;
						case (Protocol.CMD_WHO):
							StringBuilder sb = new StringBuilder("Currently connected users:\r\n");
							for (Worker w : connectedWorkers) {
								sb.append(" - ");
								sb.append(w.userName);
								sb.append("\n");
							}
							sendNotification(sb.toString());
							break;
						case (Protocol.CMD_BYE):
							PresenceServer.this.notifyConnectedWorkers(userName + " is about to leave the room.");
							connected = false;
							break;
						case (Protocol.CMD_KILL):
							sendNotification("KILL command received. Bringing server down...");
							shutdown();
							break;
						default:
							sendNotification("What? I only understand HELLO, SAY, WHO, BYE and KILL commands");
					}
				}
			} catch (IOException ex) {
				LOG.log(Level.SEVERE, ex.getMessage(), ex);
			} finally {
				unregisterWorker(this);
				PresenceServer.this.notifyConnectedWorkers(userName + " has left the room.");
				cleanup();
			}
		}

		private void cleanup() {
			LOG.log(Level.INFO, "Cleaning up worker used by {0}", userName);

			LOG.log(Level.INFO, "Closing clientSocket used by {0}", userName);
			try {
				if (clientSocket != null) {
					clientSocket.close();
				}
			} catch (IOException ex) {
				LOG.log(Level.SEVERE, ex.getMessage(), ex);
			}

			LOG.log(Level.INFO, "Closing in used by {0}", userName);
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				LOG.log(Level.SEVERE, ex.getMessage(), ex);
			}

			LOG.log(Level.INFO, "Closing out used by {0}", userName);
			if (out != null) {
				out.close();
			}

			LOG.log(Level.INFO, "Clean up done for worker used by {0}", userName);
		}

		public void sendNotification(String message) {
			out.println(message);
			out.flush();
		}

		private void disconnect() {
			LOG.log(Level.INFO, "Disconnecting worker used by {0}", userName);
			connected = false;
			cleanup();
		}

	}

}
