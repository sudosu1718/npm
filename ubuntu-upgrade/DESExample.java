import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class DESExample {

    public static String encrypt(String plainText, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String cipherText, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, key);

        byte[] encryptedBytes = Base64.getDecoder().decode(cipherText);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes);
    }

    public static void main(String[] args) throws Exception {
        // Generate a DES key
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
        SecretKey key = keyGenerator.generateKey();

        String message = "Hello, DES Algorithm!";

        // Encryption
        String encryptedMessage = encrypt(message, key);
        System.out.println("Encrypted: " + encryptedMessage);

        // Decryption
        String decryptedMessage = decrypt(encryptedMessage, key);
        System.out.println("Decrypted: " + decryptedMessage);
    }
}
