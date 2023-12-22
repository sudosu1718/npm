import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

public class BlowfishExample {

    public static void main(String[] args) {
        try {
            String keyString = "SecretKey123456"; // 128-bit key for Blowfish

            String originalText = "Hello, Blowfish!";
            System.out.println("Original Text: " + originalText);
            
            // Encryption
            String encryptedText = encrypt(originalText, keyString);
            System.out.println("Encrypted Text: " + encryptedText);

            // Decryption
            String decryptedText = decrypt(encryptedText, keyString);
            System.out.println("Decrypted Text: " + decryptedText);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String encrypt(String text, String keyString) throws Exception {
        Key key = new SecretKeySpec(keyString.getBytes(), "Blowfish");
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] encryptedBytes = cipher.doFinal(text.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String encryptedText, String keyString) throws Exception {
        Key key = new SecretKeySpec(keyString.getBytes(), "Blowfish");
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.DECRYPT_MODE, key);

        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes);
    }
}
