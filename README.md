# ElGamalEncryption

**ElGamalEncryption** is a Java implementation of the **ElGamal cryptosystem**, a public-key encryption algorithm based on the discrete logarithm problem. It supports secure encryption and decryption of messages, ensuring confidentiality and security in communication.

---

## Features

- **Public-Key Encryption**: Implements asymmetric encryption with key pairs.
- **Secure Key Exchange**: Based on the discrete logarithm problem, ensuring strong cryptographic security.
- **Lightweight Implementation**: Pure Java code with no external dependencies.
- **Educational Tool**: A great way to understand the fundamentals of public-key cryptography.

---

## Use Cases

- **Secure Communication**: Encrypt sensitive messages for safe transmission.
- **Key Exchange**: Enable secure exchange of session keys in cryptographic protocols.
- **Educational Purposes**: Learn about asymmetric encryption and its practical implementation.

---

## Installation

Copy the `ElGamalEncryption` class into your Java project. No external libraries or dependencies are needed.

---

## Usage

### Basic Example
```java
import java.math.BigInteger;
import java.security.SecureRandom;

public class Main {
    public static void main(String[] args) {
        ElGamalEncryption elGamal = new ElGamalEncryption(512); 

        String message = "Hello, ElGamal!";
        System.out.println("Original Message: " + message);

        BigInteger[] ciphertext = elGamal.encrypt(message);
        System.out.println("Encrypted Message: " + ciphertext[0] + ", " + ciphertext[1]);

        String decryptedMessage = elGamal.decrypt(ciphertext);
        System.out.println("Decrypted Message: " + decryptedMessage);
    }
}
