import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;
import java.util.Base64;

public class RijndaelExample {

    public static void main(String[] args) {
        try {
            String key = "abcdefghijklmnop"; // 128-bit key
            String originalText = "Hello, Rijndael!";

            // Encrypt
            byte[] encrypted = encrypt(originalText, key);
            System.out.println("Encrypted Text: " + Base64.getEncoder().encodeToString(encrypted));

            // Decrypt
            String decrypted = decrypt(encrypted, key);
            System.out.println("Decrypted Text: " + decrypted);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] encrypt(String plaintext, String key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

        return cipher.doFinal(plaintext.getBytes());
    }

    public static String decrypt(byte[] ciphertext, String key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

        byte[] decryptedBytes = cipher.doFinal(ciphertext);
        return new String(decryptedBytes);
    }
}
