package ch.heigvd.res.samples.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * This class demonstrates how to write custom FilterInputStream subclasses.
 * The filter does not modify the bytes when it reads them, but it counts them.
 * This makes it possible for the client to query the number of read bytes
 * afterwards, using the appropriate getter method.
 * 
 * @author Olivier Liechti
 */
public class CountingFilterInputStream extends FilterInputStream {
	
	private int numberOfReadOperations = 0;
	private int numberOfBytesRead = 0;

	public CountingFilterInputStream(InputStream in) {
		super(in);
	}

	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		int bytesRead = super.read(b, off, len); 
		if (bytesRead > 0) {
			numberOfBytesRead += bytesRead;
		}
		numberOfReadOperations++;
		return bytesRead;
	}

	@Override
	public int read(byte[] b) throws IOException {
		return read(b, 0, b.length);
	}

	@Override
	public int read() throws IOException {
		int result = super.read(); 
		if (result > 0) {
			numberOfBytesRead++;
		}
		numberOfReadOperations++;
		return result;
	}

	public int getNumberOfReadOperations() {
		return numberOfReadOperations;
	}

	public int getNumberOfBytesRead() {
		return numberOfBytesRead;
	}

	
}
