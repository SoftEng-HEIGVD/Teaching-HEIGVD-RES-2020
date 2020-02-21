package ch.heigvd.res.examples;

/**
 * The server reacts to the following commands, defined in the protocol:
 * - HELLO name: the user "behind" the client is not anonymous anymore
 * - SAY message: the message is broadcasted to connected clients
 * - WHO: the server returns the list of connected users
 * - BYE: the client is disconnected and the others are notified
 * 
 * @author Olivier Liechti
 */
public class PresenceApplication {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		System.setProperty("java.util.logging.SimpleFormatter.format", "%5$s %n");

		Thread listenThread = new Thread(new PresenceServer());
		listenThread.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		PresenceClient c1 = new PresenceClient();
		c1.connect("localhost", Protocol.PRESENCE_DEFAULT_PORT, "Sacha");
		new PresenceClient().connect("localhost", Protocol.PRESENCE_DEFAULT_PORT, "Fabienne");
		new PresenceClient().connect("localhost", Protocol.PRESENCE_DEFAULT_PORT, "Olivier");
		c1.disconnect();
		new PresenceClient().connect("localhost", Protocol.PRESENCE_DEFAULT_PORT, "Jean");
		new PresenceClient().connect("localhost", Protocol.PRESENCE_DEFAULT_PORT, "Nicole");

	}

}
