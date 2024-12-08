import java.math.BigInteger;
import java.util.Random;

public class ElGamal {
    private static final BigInteger ONE = BigInteger.ONE;
    private static final Random random = new Random();

    public static void main(String[] args) {

        BigInteger p = BigInteger.probablePrime(64, random);
        BigInteger g = new BigInteger(64, random).mod(p);
        BigInteger x = new BigInteger(64, random).mod(p.subtract(ONE));
        BigInteger y = g.modPow(x, p);

        String message = "abc";

        BigInteger[] encrypted = encrypt(message, p, g, y);
        System.out.println("Encrypted message: (" + encrypted[0] + ", " + encrypted[1] + ")");

        String decrypted = decrypt(encrypted, p, x);
        System.out.println("Decrypted message: " + decrypted);
    }

    public static BigInteger[] encrypt(String message, BigInteger p, BigInteger g, BigInteger y) {
        BigInteger[] cipher = new BigInteger[2];
        BigInteger m = new BigInteger(message.getBytes());
        BigInteger k = new BigInteger(64, random).mod(p.subtract(ONE));
        cipher[0] = g.modPow(k, p);
        cipher[1] = y.modPow(k, p).multiply(m).mod(p);
        return cipher;
    }

    public static String decrypt(BigInteger[] cipher, BigInteger p, BigInteger x) {
        BigInteger k = cipher[0].modPow(x, p);
        BigInteger m = cipher[1].multiply(k.modInverse(p)).mod(p);
        return new String(m.toByteArray());
    }
}
