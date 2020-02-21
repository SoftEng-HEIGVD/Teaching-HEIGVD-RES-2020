package ch.heigvd.res.samples.io;

import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * This class demonstrates how to write custom output stream filters. If you
 * wrap an instance around an existing class (such as an file output stream). In
 * this example, if the byte that is submitted has a value of '13', then it is
 * skipped. Otherwise, it is passed to the wrapped stream.
 * 
 * @author Olivier Liechti
 */
public class SuperstitiousFilterOutputStream extends FilterOutputStream {

	private int numberOfBytesEvaluated = 0;
	private int numberOfBytesSkipped = 0;
	private int numberOfBytesWritten = 0;

	public SuperstitiousFilterOutputStream(OutputStream out) {
		super(out);
	}

	@Override
	public void write(byte[] b, int off, int len) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		for (int i = 0; i < len; i++) {
			byte submittedByte = b[off + i];
			numberOfBytesEvaluated++;
			if (submittedByte != 13) {
				bos.write(submittedByte);
				numberOfBytesWritten++;
			} else {
				numberOfBytesSkipped++;
			}
		}
		byte[] result = bos.toByteArray();
		super.write(result, 0, result.length);
	}

	@Override
	public void write(byte[] b) throws IOException {
		write(b, 0, b.length);
	}

	@Override
	public void write(int b) throws IOException {
		numberOfBytesEvaluated++;
		if (b != 13) {
			super.write(b);
			numberOfBytesWritten++;
		} else {
			numberOfBytesSkipped++;
		}
	}

	public int getNumberOfBytesEvaluated() {
		return numberOfBytesEvaluated;
	}

	public int getNumberOfBytesSkipped() {
		return numberOfBytesSkipped;
	}

	public int getNumberOfBytesWritten() {
		return numberOfBytesWritten;
	}

}
