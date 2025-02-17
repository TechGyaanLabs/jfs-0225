package com.careerit.cj.loops.whileloop;

public class NumberOperations {


    public static void main(String[] args) {
        int num = 12345;
        System.out.println(sumOfDigits(num));
        System.out.println(reverse(num));
    }

    public static int reverse(int num) {
        if (num > 0 && num <= 9) {
            return num;
        }
        int rev = 0;
        while (num != 0) {
            int r = num % 10;
            rev = rev * 10 + r;
            num /= 10;
        }
        return rev;
    }

    public static int sumOfDigits(int num) {
        if (num > 0 && num <= 9) {
            return num;
        }
        int sum = 0;
        while (num != 0) {
            int r = num % 10;
            sum += r;
            num /= 10;
        }
        return sum;
    }
    //TODO - if given number is armstrong number return true otherwise false
    // 154 => false
    // 153 => true
    public static boolean isArmstrong(int num){
        return false;
    }

    //TODO - count the number of prime digits in the given number
    // Example: 123456 => 3
    public static int countPrimeDigits(int num){
        return 0;
    }

}
