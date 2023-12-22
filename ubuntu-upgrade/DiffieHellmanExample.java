import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class DiffieHellmanExample {

    public static void main(String[] args) throws Exception {
        // Alice's side
        KeyPairGenerator aliceKeyPairGenerator = KeyPairGenerator.getInstance("DiffieHellman");
        KeyPair aliceKeyPair = aliceKeyPairGenerator.generateKeyPair();

        // Bob's side
        KeyPairGenerator bobKeyPairGenerator = KeyPairGenerator.getInstance("DiffieHellman");
        KeyPair bobKeyPair = bobKeyPairGenerator.generateKeyPair();

        // Alice and Bob exchange public keys
        KeyAgreement aliceKeyAgreement = KeyAgreement.getInstance("DiffieHellman");
        aliceKeyAgreement.init(aliceKeyPair.getPrivate());
        aliceKeyAgreement.doPhase(bobKeyPair.getPublic(), true);

        KeyAgreement bobKeyAgreement = KeyAgreement.getInstance("DiffieHellman");
        bobKeyAgreement.init(bobKeyPair.getPrivate());
        bobKeyAgreement.doPhase(aliceKeyPair.getPublic(), true);

        // Generate shared secret
        SecretKey aliceSharedSecretKey = aliceKeyAgreement.generateSecret("DES");
        SecretKey bobSharedSecretKey = bobKeyAgreement.generateSecret("DES");

        // Check if both shared secret keys are the same
        System.out.println("Shared Secret Keys Match: " + aliceSharedSecretKey.equals(bobSharedSecretKey));
    }
}
