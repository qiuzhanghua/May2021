package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RsaTests {

    private Rsa rsa = new Rsa(2048);

    @DisplayName("0=0")
    @Test
    public void test_zero() {
        assertEquals(rsa.times(BigInteger.ZERO), BigInteger.ZERO);
    }

    @DisplayName("1=1")
    @Test
    public void test_one() {
        assertEquals(rsa.times(BigInteger.ONE), BigInteger.ONE);
    }

    @DisplayName("2 * 3 = 6")
    @Test
    public void test_2X3() {
        assertEquals(rsa.times(BigInteger.TWO, BigInteger.valueOf(3)), BigInteger.valueOf(6));
    }


    @DisplayName("4 * 7 = 28")
    @Test
    public void test_4X7() {
        assertEquals(rsa.times(BigInteger.valueOf(4), BigInteger.valueOf(7)), BigInteger.valueOf(28));
    }

    @DisplayName("7! = 5880")
    @Test
    public void test_factorial_of_7() {
        assertEquals(rsa.times(BigInteger.valueOf(7), BigInteger.valueOf(6),
                BigInteger.valueOf(5), BigInteger.valueOf(4),
                BigInteger.valueOf(3), BigInteger.valueOf(2)
        ), BigInteger.valueOf(5040));
    }

    @DisplayName("9! = 5880")
    @Test
    public void test_factorial_of_9() {
        assertEquals(rsa.times(BigInteger.valueOf(9), BigInteger.valueOf(8),
                BigInteger.valueOf(7), BigInteger.valueOf(6),
                BigInteger.valueOf(5), BigInteger.valueOf(4),
                BigInteger.valueOf(3), BigInteger.valueOf(2)
        ), BigInteger.valueOf(362880));
    }

}
