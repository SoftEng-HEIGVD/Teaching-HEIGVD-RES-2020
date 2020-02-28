package ch.heigvd.res.io;

import ch.heigvd.res.io.util.Timer;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is a very simple program, which main objective is to show that you can
 * observe very significant performance differences, depending on you implement
 * IO processing. 
 * 
 * Running the program allows you to compare both the WRITING and the READING of
 * bytes to the local file system. Different methods are compared: processing bytes
 * one by one, processing bytes in blocks, using buffered streams or not.
 * 
 * @author Olivier Liechti
 */
public class BufferedIOBenchmark {

	static final Logger LOG = Logger.getLogger(BufferedIOBenchmark.class.getName());
	private final Timer timer;

	/**
	 * This enum is used to describe the 4 different strategies for doing the IOs
	 */
	public enum IOStrategy {
		ByteByByteWithoutBufferedStream,
		ByteByByteWithBufferedStream,
		BlockByBlockWithoutBufferedStream,
		BlockByBlockWithBufferedStream
	};

	final static String FILENAME_PREFIX = "test-data"; // we will write and read test files at this location
	final static long NUMBER_OF_BYTES_TO_WRITE = 1024 * 1024 * 10; // we will write and read 10 MB files

	public BufferedIOBenchmark(Timer timer) {
		this.timer = timer;
	}

	/**
	 * This method drives the generation of test data file, based on the parameters passed. The method opens a
	 * FileOutputStream. Depending on the strategy, it wraps a BufferedOutputStream around it, or not. The method
	 * then delegates the actual production of bytes to another method, passing it the stream.
	 */
	private void produceTestData(IOStrategy ioStrategy, long numberOfBytesToWrite, int blockSize) {
		LOG.log(Level.INFO, "Generating test data ({0}, {1} bytes, block size: {2}...", new Object[]{ioStrategy, numberOfBytesToWrite, blockSize});
		timer.start();

		OutputStream os = null;
		try {
			// Let's connect our stream to a file data sink
			os = new FileOutputStream(FILENAME_PREFIX + "-" + ioStrategy + "-" + blockSize + ".bin");

			// If the strategy dictates to use a buffered stream, then let's wrap one around our file output stream
			if ((ioStrategy == IOStrategy.BlockByBlockWithBufferedStream) || (ioStrategy == IOStrategy.ByteByByteWithBufferedStream)) {
				os = new BufferedOutputStream(os);
			}

			// Now, let's call the method that does the actual work and produces bytes on the stream
			produceDataToStream(os, ioStrategy, numberOfBytesToWrite, blockSize);

			// We are done, so we only have to close the output stream
			os.close();
		} catch (IOException ex) {
			LOG.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			try {
				if (os != null) {
					os.close();
				}
			} catch (IOException ex) {
				LOG.log(Level.SEVERE, ex.getMessage(), ex);
			}
		}
		LOG.log(Level.INFO, "  > Done in {0} ms.", timer.takeTime());
	}
	
	/**
	 * This method produces bytes on the passed stream (the method does not know this stream is buffered or not)
	 * Depending on the strategy, the method either writes bytes one by one OR in chunks (the size of the chunk
	 * is passed in parameter)
	 */ 
	private void produceDataToStream(OutputStream os, IOStrategy ioStrategy, long numberOfBytesToWrite, int blockSize) throws IOException {
		// If the strategy dictates to write byte by byte, then it's easy to write the loop; but let's just hope that our client has 
		// given us a buffered output stream, otherwise the performance will be really bad
		if ((ioStrategy == IOStrategy.ByteByByteWithBufferedStream) || (ioStrategy == IOStrategy.ByteByByteWithoutBufferedStream)) {
			for (int i = 0; i < numberOfBytesToWrite; i++) {
				os.write('h');
			}

			// If the strategy dictates to write block by block, then the loop is a bit longer to write
		} else {
			long numberOfBlocks = (numberOfBytesToWrite / blockSize);
			long remainder = numberOfBytesToWrite % blockSize;
			byte[] block = new byte[blockSize];

			// we start by writing a number of entire blocks
			for (int i = 0; i < numberOfBlocks; i++) {
				for (int j = 0; j < blockSize; j++) {
					block[j] = 'b';
				}
				os.write(block);
			}

			// and we write a partial block at the end
			if (remainder != 0) {
				for (int j = 0; j < remainder; j++) {
					block[j] = 'B';
				}
				os.write(block, 0, (int) remainder);
			}
		}
	}

	/**
	 * This method drives the consumption of test data file, based on the parameters passed. The method opens a
	 * FileInputStream. Depending on the strategy, it wraps a BufferedInputStream around it, or not. The method
	 * then delegates the actual consumption of bytes to another method, passing it the stream.
	 */
	private void consumeTestData(IOStrategy ioStrategy, int blockSize) {
		LOG.log(Level.INFO, "Consuming test data ({0}, block size: {1}...", new Object[]{ioStrategy, blockSize});
		timer.start();

		InputStream is = null;
		try {
			// Let's connect our stream to a file data sink
			is = new FileInputStream(FILENAME_PREFIX + "-" + ioStrategy + "-" + blockSize + ".bin");

			// If the strategy dictates to use a buffered stream, then let's wrap one around our file input stream
			if ((ioStrategy == IOStrategy.BlockByBlockWithBufferedStream) || (ioStrategy == IOStrategy.ByteByByteWithBufferedStream)) {
				is = new BufferedInputStream(is);
			}

			// Now, let's call the method that does the actual work and produces bytes on the stream
			consumeDataFromStream(is, ioStrategy, blockSize);

			// We are done, so we only have to close the input stream
			is.close();
		} catch (IOException ex) {
			LOG.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException ex) {
				LOG.log(Level.SEVERE, ex.getMessage(), ex);
			}
		}
		LOG.log(Level.INFO, "  > Done in {0} ms.", timer.takeTime());

	}

	/**
	 * This method consumes bytes on the passed stream (the method does not know this stream is buffered or not)
	 * Depending on the strategy, the method either reads bytes one by one OR in chunks (the size of the chunk
	 * is passed in parameter). The method does not do anything with the read bytes, except counting them.
	 */ 
	private void consumeDataFromStream(InputStream is, IOStrategy ioStrategy, int blockSize) throws IOException {
		int totalBytes = 0;
		// If the strategy dictates to write byte by byte, then it's easy to write the loop; but let's just hope that our client has 
		// given us a buffered output stream, otherwise the performance will be really bad
		if ((ioStrategy == IOStrategy.ByteByByteWithBufferedStream) || (ioStrategy == IOStrategy.ByteByByteWithoutBufferedStream)) {
			int c;
			while ((c = is.read()) != -1) {
				// here, we could cast c to a byte and process it
				totalBytes++;
			}

			// If the strategy dictates to write block by block, then the loop is a bit longer to write
		} else {
			byte[] block = new byte[blockSize];
			int bytesRead = 0;
			while ((bytesRead = is.read(block)) != -1) {
				// here, we can process bytes block[0..bytesRead]
				totalBytes += bytesRead;
			}
		}
		
		LOG.log(Level.INFO, "Number of bytes read: {0}", new Object[]{totalBytes});
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		System.setProperty("java.util.logging.SimpleFormatter.format", "%5$s %n");

		Timer timer = new Timer();
		BufferedIOBenchmark bm = new BufferedIOBenchmark(timer);

		LOG.log(Level.INFO, "");
		LOG.log(Level.INFO, "*** BENCHMARKING WRITE OPERATIONS (with BufferedStream)", timer.takeTime());
		bm.produceTestData(IOStrategy.BlockByBlockWithBufferedStream, NUMBER_OF_BYTES_TO_WRITE, 500);
		bm.produceTestData(IOStrategy.BlockByBlockWithBufferedStream, NUMBER_OF_BYTES_TO_WRITE, 50);
		bm.produceTestData(IOStrategy.BlockByBlockWithBufferedStream, NUMBER_OF_BYTES_TO_WRITE, 5);
		bm.produceTestData(IOStrategy.ByteByByteWithBufferedStream, NUMBER_OF_BYTES_TO_WRITE, 0);

		LOG.log(Level.INFO, "");
		LOG.log(Level.INFO, "*** BENCHMARKING WRITE OPERATIONS (without BufferedStream)", timer.takeTime());
		bm.produceTestData(IOStrategy.BlockByBlockWithoutBufferedStream, NUMBER_OF_BYTES_TO_WRITE, 500);
		bm.produceTestData(IOStrategy.BlockByBlockWithoutBufferedStream, NUMBER_OF_BYTES_TO_WRITE, 50);
		bm.produceTestData(IOStrategy.BlockByBlockWithoutBufferedStream, NUMBER_OF_BYTES_TO_WRITE, 5);
		bm.produceTestData(IOStrategy.ByteByByteWithoutBufferedStream, NUMBER_OF_BYTES_TO_WRITE, 0);

		LOG.log(Level.INFO, "");
		LOG.log(Level.INFO, "*** BENCHMARKING READ OPERATIONS (with BufferedStream)", timer.takeTime());
		bm.consumeTestData(IOStrategy.BlockByBlockWithBufferedStream, 500);
		bm.consumeTestData(IOStrategy.BlockByBlockWithBufferedStream, 50);
		bm.consumeTestData(IOStrategy.BlockByBlockWithBufferedStream, 5);
		bm.consumeTestData(IOStrategy.ByteByByteWithBufferedStream, 0);
		
		LOG.log(Level.INFO, "");
		LOG.log(Level.INFO, "*** BENCHMARKING READ OPERATIONS (without BufferedStream)", timer.takeTime());
		bm.consumeTestData(IOStrategy.BlockByBlockWithoutBufferedStream, 500);
		bm.consumeTestData(IOStrategy.BlockByBlockWithoutBufferedStream, 50);
		bm.consumeTestData(IOStrategy.BlockByBlockWithoutBufferedStream, 5);
		bm.consumeTestData(IOStrategy.ByteByByteWithoutBufferedStream, 0);
	}

}
