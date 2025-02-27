package com.careerit.cj.basics;

import java.math.BigInteger;

public class DataTypeSizeExample {
    public static void main(String[] args) {
        BigInteger big = fact(30);
        System.out.println(big.toString());
    }

    private static BigInteger fact(int i) {
        if (i == 0) {
            return BigInteger.ONE;
        } else {
            return fact(i - 1).multiply(BigInteger.valueOf(i));
        }
    }


}
