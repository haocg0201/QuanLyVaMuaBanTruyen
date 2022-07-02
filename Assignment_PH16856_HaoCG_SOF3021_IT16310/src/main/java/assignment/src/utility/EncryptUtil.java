package assignment.src.utility;

import org.mindrot.jbcrypt.BCrypt;

public class EncryptUtil {
	public static String encrypt(String origin) {
		String encrypted = BCrypt.hashpw(origin, BCrypt.gensalt());
		return encrypted;
	}
	
	public static boolean check(
			String origin,String encrypt) {
		return BCrypt.checkpw(origin, encrypt);
	}
}
