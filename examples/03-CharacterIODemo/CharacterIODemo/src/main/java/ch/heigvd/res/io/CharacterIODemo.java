package ch.heigvd.res.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This program shows how to use character encodings in Java. It shows that while
 * Java uses Unicode once characters or Strings are created in memory, a translation
 * needs to happen when bytes are converted into characters, and the other way around.
 * 
 * The program also highlight typical problems that arise if the developer does not
 * control character encodings. Problems that manifest themselves by seeing '?' or
 * other strange characters appear in text messages.
 * 
 * It is a good idea to run this program in debug mode, to be able to explore the
 * memory representations of the manipulated strings.
 * 
 * @author Olivier Liechti
 */
public class CharacterIODemo {
	
	/**
	 * This method manipulates the Unicode string passed in parameter. It first
	 * converts it into a byte array, using the specified encoding (hence, using
	 * different encodings should produce different byte arrays, possibly of 
	 * different sizes!). It then converts the byte array back into a String. It
	 * does this twice: a first time using the default encoding (platform specific)
	 * and a second time using the specified encoding.
	 * 
	 * @param message the test String we want to encode
	 * @param encoding the encoding we want to use for encoding/decoding message
	 * @throws java.io.IOException
	 */
	public void encodeAndDecode(String message, String encoding) throws IOException {
		// Lets create an output stream, which will send written bytes to a memory zone
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		
		// Let's wrap an OutputStreamWriter around it. When writing characters on
		// this writer, it will be responsible for converting them into sequences of
		// bytes. How? By using the encoding that we pass as parameter.
		OutputStreamWriter writer = new OutputStreamWriter(os, encoding);
		writer.write(message);
		writer.flush();
		
		// We have sent characters to the writer, it has translated them into bytes.
		// These bytes have been forwarded to the wrapped ByteArrayOutputStream instance.
		// We can now fetch these bytes.
		byte[] encodedMessage = os.toByteArray();
		
		System.out.println("When I encode '" + message + "' (" + message.length() + " chars) with encoding " + encoding + ", I generate " + encodedMessage.length + " bytes.");
		dumpByteArray(encodedMessage);

		// Now, let's do the work the other way around. Let's take the byte array and convert it
		// to a Java String. Note that there are different constructors in the Java class. Some would let
		// us specify the encoding (i.e. specify how we want to translates bytes into characters). In this
		// case, we are using the default one (which you can specify by starting your JVM with -Dfile.encoding=XXX).
		// So, we expect this call to break in many cases! If we converted our test string using the UTF-16 encoding,
		// and then use to the UTF-8 encoding in the other direction, we will have corrupted our string!
		String decodedMessage = new String(encodedMessage);
		System.out.print("If I decode the result with the default encoding for this JVM (" + System.getProperty("file.encoding") + "), I get: ");
		System.out.println(decodedMessage);

		
		// Now, let's use the same encoding for converting the byte array back into a String. That should work better in some
		// cases, BUT we will also encounter situations where the message is not displayed correctly. The reason is that encoding
		// our test string into bytes MAY result in losing some information. For instance, if our test string contains japanese 
		// characters and we encode it with ASCII, then the encoder will be lost. It will be unable to process japanese characters
		// and will replace them with '?' characters. Once this is done, when we try to go back from the byte array to the String,
		// we will have lost some of the information and won't be able to recover the original string.
		decodedMessage = new String(encodedMessage, encoding);
		System.out.print("If I decode the result with the same encoding (" + encoding + ") for this JVM (" + System.getProperty("file.encoding") + "), I get: ");
		System.out.println(decodedMessage);
		System.out.println();
	}
	
	/**
	 * A utility method to dump a byte array (showing the binary and decimal values)
	 * onto the console.
	 * 
	 * @param array the byte array we want to show 
	 */
	private void dumpByteArray(byte[] array) {
		for (int i=0; i<array.length; i++) {
			String s1 = String.format("%8s", Integer.toBinaryString(array[i] & 0xFF)).replace(' ', '0');
			String s2 = String.format("%5s", array[i]).replace(' ', ' ');
			System.out.print(s1 + "  " + s2 + "\n");
		}
		
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		CharacterIODemo demo = new CharacterIODemo();
		
		// Let's see how 1) plain latin characters, 2) characters with accents 
		// and 3) japanese characters work with our test procedure
		
		String message = "ABC élève　広島";
		
		try {
			
			// Do a run with the ASCII encoding (no support for accents, nor japanese)
			demo.encodeAndDecode(message, "US-ASCII");
			
			// Do a run with the latin western european  encoding (support for accents, not japanese)
			demo.encodeAndDecode(message, "ISO-8859-15");

			// Do a run with the UTF-8 encoding
			demo.encodeAndDecode(message, "UTF-8");

			// Do a run with the UTF-16 encoding
			demo.encodeAndDecode(message, "UTF-16");
			
		} catch (IOException ex) {
			Logger.getLogger(CharacterIODemo.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
}
