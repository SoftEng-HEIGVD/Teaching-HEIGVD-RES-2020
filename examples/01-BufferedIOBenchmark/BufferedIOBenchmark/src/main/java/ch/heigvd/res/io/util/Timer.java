package ch.heigvd.res.io.util;

/**
 *
 * @author Olivier Liechti
 */
public class Timer {
	
	private static long timestamp = 0;
	
	public void start() {
		timestamp = System.currentTimeMillis();
	}
	
	public long takeTime() {
		if (timestamp == 0) {
			timestamp = System.currentTimeMillis();
		}
		long ellapsedTime = System.currentTimeMillis() - timestamp;
		timestamp = System.currentTimeMillis();
	  return ellapsedTime;
	}
	
	public String display(long millis) {
		long milliseconds = millis % 1000;
		long seconds = millis / 1000;
		long minutes = seconds / 60;
		seconds = seconds % 60;
		
		return String.format("%d min, %d sec, %d ms", minutes, seconds, milliseconds);
	}

}
