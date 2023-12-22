public class VigenereCipher {

    public static String encrypt(String plainText, String key) {
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0, j = 0; i < plainText.length(); i++) {
            char c = plainText.charAt(i);
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                int keyIndex = j % key.length();
                char keyChar = key.charAt(keyIndex);
                encryptedText.append((char) ((c - base + keyChar - 'A') % 26 + base));
                j++;
            } else {
                encryptedText.append(c);
            }
        }

        return encryptedText.toString();
    }

    public static String decrypt(String cipherText, String key) {
        StringBuilder decryptedText = new StringBuilder();

        for (int i = 0, j = 0; i < cipherText.length(); i++) {
            char c = cipherText.charAt(i);
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                int keyIndex = j % key.length();
                char keyChar = key.charAt(keyIndex);
                decryptedText.append((char) ((c - base - (keyChar - 'A') + 26) % 26 + base));
                j++;
            } else {
                decryptedText.append(c);
            }
        }

        return decryptedText.toString();
    }

    public static void main(String[] args) {
        String message = "Hello, Vigenere Cipher!";
        String key = "KEY";

        String encryptedMessage = encrypt(message, key);
        System.out.println("Encrypted: " + encryptedMessage);

        String decryptedMessage = decrypt(encryptedMessage, key);
        System.out.println("Decrypted: " + decryptedMessage);
    }
}
