package com.example;

import java.math.BigInteger;
import java.util.Random;

public class Rsa {
    private BigInteger n;
    private BigInteger e;
    private BigInteger d;

    public Rsa(Integer bits) {
        Random r = new Random();
        BigInteger p = BigInteger.probablePrime(bits, r);
        BigInteger q = BigInteger.probablePrime(bits, r);
        n = p.multiply(q);
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        e = BigInteger.probablePrime(bits / 2, r);
        while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0) {
            e.add(BigInteger.ONE);
        }
        d = e.modInverse(phi);
    }

    public Rsa(BigInteger e, BigInteger d, BigInteger n) {
        this.e = e;
        this.d = d;
        this.n = n;
    }

    public BigInteger encryptBigInteger(BigInteger source) {
        return source.modPow(e, n);
    }

    public BigInteger decryptBigInteger(BigInteger source) {
        return source.modPow(d, n);
    }

    // Encrypting the message
    public byte[] encryptMessage(byte[] message) {
        return (new BigInteger(message)).modPow(e, n).toByteArray();
    }

    // Decrypting the message
    public byte[] decryptMessage(byte[] message) {
        return (new BigInteger(message)).modPow(d, n).toByteArray();
    }

    public static String bytes2String(byte[] cipher) {
        StringBuffer sb = new StringBuffer();
        for (byte b : cipher) {
            sb.append(Byte.toString(b));
        }
        return sb.toString();
    }

}
