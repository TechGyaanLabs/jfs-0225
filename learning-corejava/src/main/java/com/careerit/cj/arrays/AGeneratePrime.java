package com.careerit.cj.arrays;

public class AGeneratePrime {

    public static void main(String[] args) {

        int[] primeNumbers = generatePrime(20);

        for (int i = 0; i < primeNumbers.length; i++) {
            System.out.println(primeNumbers[i]);
        }

        double[] avgMinMax = getSumAvgMaxAndMin(primeNumbers);

        for (int i = 0; i < avgMinMax.length; i++) {
            System.out.println(avgMinMax[i]);
        }


    }

    public static int[] generatePrime(int n) {
        return null;
    }

    public static double[] getSumAvgMaxAndMin(int[] arr) {
        return null;
    }

}
