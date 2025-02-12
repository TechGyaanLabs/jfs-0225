package com.careerit.cj.basics;

public class SumOfNNaturalNumbers {

    public static void main(String[] args) {

        int n = 100; // 1 + 2 + 3 + 4 + 5 ......
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = i;
        }
        System.out.println("The sum of first " + n + " natural numbers is " + sum);

    }
}
