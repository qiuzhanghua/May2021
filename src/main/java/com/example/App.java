package com.example;

import java.math.BigInteger;

import org.apache.commons.codec.binary.Hex;

public class App {
    public static void main(String[] args) {
        Integer bits = 2048;
        Rsa rsa = new Rsa(bits);
        BigInteger x = new BigInteger("10324234");
        BigInteger y = new BigInteger("546576");
        BigInteger z = rsa.times(x, y);
        System.out.printf("%d * %d = %d", x, y, z);
/*
        String input = "Homomorphic Encryption to Test Rsa";
        System.out.println("Encrypting the message: " + input);
        System.out.println("The message in Hex is: "
                + Hex.encodeHexString(input.getBytes()));
        byte[] cipher = rsa.encryptMessage(input.getBytes());
        byte[] plain = rsa.decryptMessage(cipher);
        System.out.println("Decrypting Bytes: " + Hex.encodeHexString(plain));
        System.out.println("Plain message is: " + new String(plain));
*/
    }
}
