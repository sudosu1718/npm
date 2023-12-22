import java.security.*;

public class DigitalSignatureStandard {
    public static void main(String[] args) {
        try {
            // Generate key pair
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");
            SecureRandom random = new SecureRandom();
            keyGen.initialize(1024, random);

            KeyPair keyPair = keyGen.generateKeyPair();

            // Create Signature object
            Signature dsa = Signature.getInstance("SHA1withDSA");

            // Initialize Signature object with private key
            PrivateKey privateKey = keyPair.getPrivate();
            dsa.initSign(privateKey);

            // Data to be signed
            byte[] data = "Hello, Digital Signature!".getBytes();

            // Update data to be signed
            dsa.update(data);

            // Generate digital signature
            byte[] signature = dsa.sign();

            System.out.println("Digital Signature: " + bytesToHex(signature));

            // Verify signature
            Signature verifier = Signature.getInstance("SHA1withDSA");
            PublicKey publicKey = keyPair.getPublic();
            verifier.initVerify(publicKey);
            verifier.update(data);

            boolean isVerified = verifier.verify(signature);

            System.out.println("Signature Verified: " + isVerified);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Helper method to convert byte array to hex string
    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02X", b));
        }
        return result.toString();
    }
}
