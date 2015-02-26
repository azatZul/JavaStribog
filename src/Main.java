import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

public class Main {
	private static final String[] hashNames = { "Stribog256", "Stribog512" };

	private static final byte[] message = new byte[] { 0x32, 0x31, 0x30, 0x39,
			0x38, 0x37, 0x36, 0x35, 0x34, 0x33, 0x32, 0x31, 0x30, 0x39, 0x38,
			0x37, 0x36, 0x35, 0x34, 0x33, 0x32, 0x31, 0x30, 0x39, 0x38, 0x37,
			0x36, 0x35, 0x34, 0x33, 0x32, 0x31, 0x30, 0x39, 0x38, 0x37, 0x36,
			0x35, 0x34, 0x33, 0x32, 0x31, 0x30, 0x39, 0x38, 0x37, 0x36, 0x35,
			0x34, 0x33, 0x32, 0x31, 0x30, 0x39, 0x38, 0x37, 0x36, 0x35, 0x34,
			0x33, 0x32, 0x31, 0x30 };

	public static void main(String[] argv) throws NoSuchAlgorithmException {
		// byte[] message = "Обычное сообщение".getBytes();
		byte[] test = "210987654321098765432109876543210987654321098765432109876543210"
				.getBytes();
		if (Security.getProvider("Stribog") == null) {
			Security.addProvider(new StribogProvider());
		}
		for (String hashName : hashNames) {
			MessageDigest md = MessageDigest.getInstance(hashName);
			byte[] digest = md.digest(test);
			printHex(digest);
		}

	}

	private static void printHex(byte[] digest) {
		for (byte b : digest) {
			int iv = b & 0xFF;
			if (iv < 0x10) {
				System.out.print('0');
			}
			System.out.print(Integer.toHexString(iv).toUpperCase());
		}
		System.out.println();
	}

	private static byte[] reverse(byte[] ba) {
		byte[] result = new byte[ba.length];
		for (int i = ba.length - 1; i >= 0; i--) {
			result[ba.length - 1 - i] = ba[i];
		}
		return result;
	}

}
