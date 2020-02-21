package ch.heigvd.res.samples.io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class provides a method to generate a test file, by producing random
 * bytes and writing them to a FileOutputStream instance.
 * 
 * @author Olivier Liechti
 */
public class Generator {

	private static final int BUFFER_SIZE = 512;

	public void generateTestFile(String filename, int fileSize) {
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try {
			fos = new FileOutputStream(filename);
			bos = new BufferedOutputStream(fos);
			byte[] buffer = new byte[BUFFER_SIZE];
			for (int i = 0; i < fileSize / BUFFER_SIZE; i++) {
				fillBuffer(buffer);
				bos.write(buffer);
			}
			if (fileSize % BUFFER_SIZE != 0) {
				fillBuffer(buffer);
				bos.write(buffer, 0, fileSize % BUFFER_SIZE);
			}
		} catch (IOException ex) {
			Logger.getLogger(Generator.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				bos.close();
			} catch (IOException ex) {
				Logger.getLogger(Generator.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	private void fillBuffer(byte[] buffer) {
		for (int i = 0; i < buffer.length; i++) {
			buffer[i] = (byte) (Math.random() * 255);
		}
	}

}
