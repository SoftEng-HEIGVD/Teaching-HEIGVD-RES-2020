/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.res.examples;

/**
 * This application shows the difference between a single threaded TCP server
 * and a multi threaded TCP server. It shows that the first one is only able to
 * process one client at the time, which is obviously not really an option for
 * most applications. The second one uses n+1 threads, where n is the number of
 * clients currently connected. The extra thread is used to wait for new clients
 * to arrive, in a loop.
 *
 * The application starts the multi-threaded server on port 2323 and the
 * single-threaded server on port 2424. Use several terminals and the telnet
 * command to (try to) connect to the servers and compare the behavior.
 *
 * @author Olivier Liechti
 */
public class TcpServers {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		System.setProperty("java.util.logging.SimpleFormatter.format", "%5$s %n");

		MultiThreadedServer multi = new MultiThreadedServer(2323);
		multi.serveClients();

		SingleThreadedServer single = new SingleThreadedServer(2424);
		single.serveClients();
	}

}
