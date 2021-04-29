package com.example;

import java.math.BigInteger;

//import static com.example.Rsa.bytes2String;
import org.apache.commons.codec.binary.Hex;

public class App {
    public static void main(String[] args) {
        Integer bits = 4096;
        Rsa rsa = new Rsa(bits);
        BigInteger x = new BigInteger("33");
        BigInteger y = new BigInteger("7");
        BigInteger ex = rsa.encryptBigInteger(x);
        BigInteger ey = rsa.encryptBigInteger(y);
        BigInteger ez = ex.multiply(ey);
        BigInteger z = rsa.decryptBigInteger(ez);
        System.out.println(z);
        String input = "Hello, How are you?";
        System.out.println("Encrypting the message: " + input);
//        System.out.println("The message in bytes is: "
//                + bytes2String(input.getBytes()));
        System.out.println("The message in Hex is: "
                + Hex.encodeHexString(input.getBytes()));

        // encryption
        byte[] cipher = rsa.encryptMessage(input.getBytes());
        // decryption
        byte[] plain = rsa.decryptMessage(cipher);
//        System.out.println("Decrypting Bytes: " + bytes2String(plain));
        System.out.println("Decrypting Bytes: " + Hex.encodeHexString(plain));
        System.out.println("Plain message is: " + new String(plain));
    }
}
