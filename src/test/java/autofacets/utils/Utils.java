package autofacets.utils;

import org.jasypt.util.text.BasicTextEncryptor;
import org.testng.Reporter;

import java.io.Console;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Properties;
import java.util.Random;

/**
 * @author niravpatel
 *
 */

public class Utils {

	public static void breakLine() {
		System.out.println("");
	}

	public static void createFile(String data) {
		String fileData = data;
		try {
			FileOutputStream fos = new FileOutputStream("./resources/data.txt");
			fos.write(fileData.getBytes());
			fos.flush();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void pause(long timeout) {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void pause(long timeout, String msg) {
		try {
			Thread.sleep(timeout);
			Reporter.log(msg);
			//System.out.println(msg);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static String getFileValues(String key, String path) {
		Properties properties = new Properties();
		FileInputStream fileInputStream = null;
		String values = null;
		try {
			fileInputStream = new FileInputStream(path);
			properties.load(fileInputStream);
			values = properties.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		return values;
	}

	public static String passwordEncryptDecrypt(String encryptedPassword) {
		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
		textEncryptor.setPassword("jasypt");
		String plainText = textEncryptor.decrypt(encryptedPassword);
		return plainText;
	}

	public static class log {
		public static void step(String step) {
			System.out.println("\n" + ":::::::: " + step + " :::::::: \n");
		}

		public static void printMessage(String message) {
			System.out.println("");
			System.out.println(message);
		}

		public static void consoleLogs(String step) {
			System.out.println("\n" + "Console Logs:::::::: " + step + " :::::::: Ends\n");
		}
	}
	
	public static String decryptPassword(String password) {
		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
		textEncryptor.setPassword("jasypt");
		return textEncryptor.decrypt(password);
	}
	
	public static String decryptURL(String URL) {
		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
		textEncryptor.setPassword("jasypt");
		return textEncryptor.decrypt(URL);
	}

	public static String randomString() {
		byte[] array = new byte[2000]; // length is bounded by 7
		new Random().nextBytes(array);
		String generatedString = new String(array, Charset.forName("UTF-8"));
		System.out.println(generatedString);
		return  generatedString;
	}

	public static String alphaNumericRandomString() {
		int leftLimit = 48; // numeral '0'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 5000;
		Random random = new Random();
		String generatedString = random.ints(leftLimit, rightLimit + 1)
				.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
				.limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
				.toString();
		System.out.println(generatedString);
		return  generatedString;
	}
}
