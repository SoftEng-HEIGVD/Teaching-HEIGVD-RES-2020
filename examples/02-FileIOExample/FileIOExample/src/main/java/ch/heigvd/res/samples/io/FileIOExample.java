package ch.heigvd.res.samples.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This simple application shows how to use standard Java IO classes to read,
 * process and write bytes stored in files. The program first generates a number
 * of test files (with random byte values).
 * <p>
 * It then duplicates one of these files, applying two filters in the process.
 * Every byte read is counted, so that the number of read bytes (and the number
 * of read operations) can be queried afterwards. Every byte tentatively written
 * is checked by another filter stream. If the byte has a value of 13, then it
 * is NOT written and is ignored. The number of skipped bytes is counted.
 *
 * @author Olivier Liechti
 */
public class FileIOExample {

  private final static String FILEPATH = "./test-file.bin";
  private final static int FILESIZE = 5120;

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {

    // We will use two classes to generate, then duplicate test files
    Generator generator = new Generator();
    Duplicator duplicator = new Duplicator();

    // Let's generate a number of test files, with different sizes
    generator.generateTestFile(FILEPATH, FILESIZE);

    CountingFilterInputStream is = null;
    SuperstitiousFilterOutputStream os = null;

    try {
      // We want to count the number of bytes read from the file AND we want to make sure that performance is adequate
      // So, we wrap an instance of our own CountingFilterInputStream around a BufferedInputStream, and wrap this one around
      // the FileInputStream
      is = new CountingFilterInputStream(new BufferedInputStream(new FileInputStream(FILEPATH)));

      // We want to skip bytes that have a value of '13' during the duplicaiton process, so we use our own SuperstitiousFilterOutputStream
      os = new SuperstitiousFilterOutputStream(new BufferedOutputStream(new FileOutputStream(FILEPATH + ".copy")));

      // We have our 2 streams, connected to 2 files, so we can ask duplicator to do its job. Note that duplicator does not know that he
      // is working on files, we could have passed streams connected to network endpoints or to other processes
      duplicator.duplicate(is, os);

      Logger.getLogger(FileIOExample.class.getName()).log(Level.INFO, "{0} bytes read in {1} operations.", new Object[]{is.getNumberOfBytesRead(), is.getNumberOfReadOperations()});
      Logger.getLogger(FileIOExample.class.getName()).log(Level.INFO, " {0} bytes written, {1} bytes skipped, for a total of {2} bytes evaluated.", new Object[]{os.getNumberOfBytesWritten(), os.getNumberOfBytesSkipped(), os.getNumberOfBytesEvaluated()});


    } catch (IOException ex) {
      Logger.getLogger(FileIOExample.class.getName()).log(Level.SEVERE, null, ex);

    } finally {

      // We are done, so let's close the streams.
      try {
        is.close();
      } catch (IOException ex) {
        Logger.getLogger(FileIOExample.class.getName()).log(Level.SEVERE, null, ex);
      }
      try {
        os.close();
      } catch (IOException ex) {
        Logger.getLogger(FileIOExample.class.getName()).log(Level.SEVERE, null, ex);
      }

    }
  }

}
