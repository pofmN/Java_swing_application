package Do_an_own;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashFunction {
	private static final String DatatypeConverter = null;	

	public String ConvertHashtoString(String text) throws NoSuchAlgorithmException {
	 MessageDigest md = MessageDigest.getInstance("MD5");
	 byte[] hashInBytes = md.digest(text.getBytes(StandardCharsets.UTF_8));
	 StringBuilder sb = new StringBuilder();
	 for (byte b : hashInBytes) {
		 sb.append(String.format("%02x", b));
	 }
	 return sb.toString();
  }
	public static void main(String[] args) {
		HashFunction hs = new HashFunction();
		try {
			String rs = hs.ConvertHashtoString("");
			System.out.println("Result: "+rs);
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}
	}
}  
