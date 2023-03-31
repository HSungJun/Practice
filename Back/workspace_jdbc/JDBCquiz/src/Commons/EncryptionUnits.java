tnwls960@package Commons;

import java.security.MessageDigest;

public class EncryptionUnits {

	public static String sha256(String msg) throws Exception {
	       MessageDigest md = MessageDigest.getInstance("SHA-256");
	       md.update(msg.getBytes());
	       StringBuilder builder = new StringBuilder();
	       for (byte b: md.digest()) {
	            builder.append(String.format("%02x", b));
	      }
	       return builder.toString();
	   }
}
