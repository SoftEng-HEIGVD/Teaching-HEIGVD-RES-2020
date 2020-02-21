package ch.heigvd.res.examples;

import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is not really an HTTP client, but rather a very simple program that
 * establishes a TCP connection with a real HTTP server. Once connected, the 
 * client sends "garbage" to the server (the client does not send a proper
 * HTTP request that the server would understand). The client then reads the
 * response sent back by the server and logs it onto the console.
 * 
 * @author Olivier Liechti
 */
public class DumbHttpClient {

	static final Logger LOG = Logger.getLogger(DumbHttpClient.class.getName());

	final static int BUFFER_SIZE = 1024;

	/**
	 * This method does the whole processing
	 */
	public void sendWrongHttpRequest() {
		Socket clientSocket = null;
		OutputStream os = null;
		InputStream is = null;
		
		try {
			clientSocket = new Socket("localhost", 2019);
			os = clientSocket.getOutputStream();
			is = clientSocket.getInputStream();

			String malformedHttpRequest = "Hello, sorry, but I don't speak HTTP...\r\n\r\n";
			os.write(malformedHttpRequest.getBytes());

			ByteArrayOutputStream responseBuffer = new ByteArrayOutputStream();
			byte[] buffer = new byte[BUFFER_SIZE];
			int newBytes;
			while ((newBytes = is.read(buffer)) != -1) {
				responseBuffer.write(buffer, 0, newBytes);
			}

			LOG.log(Level.INFO, "Response sent by the server: ");
			LOG.log(Level.INFO, responseBuffer.toString());
		} catch (IOException ex) {
			LOG.log(Level.SEVERE, null, ex);
		} finally {
			try {
				is.close();
			} catch (IOException ex) {
				Logger.getLogger(DumbHttpClient.class.getName()).log(Level.SEVERE, null, ex);
			}
			try {
				os.close();
			} catch (IOException ex) {
				Logger.getLogger(DumbHttpClient.class.getName()).log(Level.SEVERE, null, ex);
			}
			try {
				clientSocket.close();
			} catch (IOException ex) {
				Logger.getLogger(DumbHttpClient.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		System.setProperty("java.util.logging.SimpleFormatter.format", "%5$s %n");

		DumbHttpClient client = new DumbHttpClient();
		client.sendWrongHttpRequest();

	}

}
