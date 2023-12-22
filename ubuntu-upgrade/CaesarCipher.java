public class CaesarCipher {

    public static String encrypt(String plainText, int shift) {
        StringBuilder encryptedText = new StringBuilder();

        for (char c : plainText.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                encryptedText.append((char) ((c - base + shift) % 26 + base));
            } else {
                encryptedText.append(c);
            }
        }
        return encryptedText.toString();
    }

    public static String decrypt(String cipherText, int shift) {
        return encrypt(cipherText, 26 - shift);
    }

    public static void main(String[] args) {
        String message = "Hello, Caesar Cipher!";
        int shift = 3;

        String encryptedMessage = encrypt(message, shift);
        System.out.println("Encrypted: " + encryptedMessage);

        String decryptedMessage = decrypt(encryptedMessage, shift);
        System.out.println("Decrypted: " + decryptedMessage);
    }
}
