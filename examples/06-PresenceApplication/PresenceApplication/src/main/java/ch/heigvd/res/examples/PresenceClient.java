package ch.heigvd.res.examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class implements a simple client for our custom presence protocol.
 * When the client connects to a server, a thread is started to listen for
 * notifications sent by the server.
 * 
 * @author Olivier Liechti
 */
public class PresenceClient {

	final static Logger LOG = Logger.getLogger(PresenceClient.class.getName());

	Socket clientSocket;
	BufferedReader in;
	PrintWriter out;
	boolean connected = false;
	String userName;

	/**
	 * This inner class implements the Runnable interface, so that the run()
	 * method can execute on its own thread. This method reads data sent from the
	 * server, line by line, until the connection is closed or lost.
	 */
	class NotificationListener implements Runnable {

		@Override
		public void run() {
			String notification;
			try {
				while ((connected && (notification = in.readLine()) != null)) {
					LOG.log(Level.INFO, "Server notification for {1}: {0}", new Object[]{notification,userName});
				}
			} catch (IOException e) {
				LOG.log(Level.SEVERE, "Connection problem in client used by {1}: {0}", new Object[]{e.getMessage(),userName});
				connected = false;
			} finally {
				cleanup();
			}
		}
	}

	/**
	 * This method is used to connect to the server and to inform the server that
	 * the user "behind" the client has a name (in other words, the HELLO command
	 * is issued after successful connection).
	 * 
	 * @param serverAddress the IP address used by the Presence Server
	 * @param serverPort the port used by the Presence Server
	 * @param userName the name of the user, used as a parameter for the HELLO command
	 */
	public void connect(String serverAddress, int serverPort, String userName) {
		try {
			clientSocket = new Socket(serverAddress, serverPort);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			out = new PrintWriter(clientSocket.getOutputStream());
			connected = true;
			this.userName = userName;
		} catch (IOException e) {
			LOG.log(Level.SEVERE, "Unable to connect to server: {0}", e.getMessage());
			cleanup();
			return;
		}
		// Let us start a thread, so that we can listen for server notifications
		new Thread(new NotificationListener()).start();
		
		// Let us send the HELLO command to inform the server about who the user
		// is. Other clients will be notified.
		out.println("HELLO " + userName);
		out.flush();
	}

	public void disconnect() {
		LOG.log(Level.INFO, "{0} has requested to be disconnected.", userName);
		connected = false;
		out.println("BYE");
		cleanup();
	}

	private void cleanup() {

		try {
			if (in != null) {
				in.close();
			}
		} catch (IOException ex) {
			LOG.log(Level.SEVERE, ex.getMessage(), ex);
		}

		if (out != null) {
			out.close();
		}

		try {
			if (clientSocket != null) {
				clientSocket.close();
			}
		} catch (IOException ex) {
			LOG.log(Level.SEVERE, ex.getMessage(), ex);
		}
	}


}
