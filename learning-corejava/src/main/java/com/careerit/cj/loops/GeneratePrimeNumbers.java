package com.careerit.cj.loops;

import java.util.Arrays;

public class GeneratePrimeNumbers {

    public static void main(String[] args) {

        // Generate prime numbers in the given range ( 10, 12)
        int lowerBound = 20;
        int upperBound = 50;
        int[] primesInRangeArr = getPrimes(lowerBound,upperBound);
        System.out.println(Arrays.toString(primesInRangeArr));

    }

    // 10 => 1,2,5,10
    // 17 => 1,17
    // 20 => 1,2,4,5,10,20

    public static int[] getPrimes(int lb, int ub) {
        int[] arr = new int[0];
        int primeCount = primeCount(lb,ub);
        if(primeCount != 0){
            int index = 0;
            arr = new int[primeCount];
            for(int i=lb;i<=ub;i++){
                if(isPrime(i)){
                    arr[index++] = i;
                }
            }
        }
        return arr;
    }

    public static int primeCount(int lb, int ub) {
        int count = 0;
        for (int i = lb; i <= ub; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    public static boolean isPrime(int num) {
        if (num < 2 || (num % 2 == 0 && num != 2)) {
            return false;
        }
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }


}
