package ch.heigvd.res.samples.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * This class reads input from an input stream and writes it to an output stream
 * @author Olivier Liechti
 */
public class Duplicator {
	
	private static final int BUFFER_SIZE = 512;
	
	public void duplicate(InputStream is, OutputStream os) throws IOException {
		byte[] buffer = new byte[BUFFER_SIZE];
		int readBytes = 0;
		while ( (readBytes = is.read(buffer)) != -1 ) {
			os.write(buffer, 0, readBytes);
		}
	}

}
