package com.careerit.cj.day3;

import java.util.Scanner;

public class SumOfFirstNNaturalNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the N value :");
        int n = sc.nextInt();
        // n * n + 1 / 2 => n * (n + 1) / 2 => 10 * 11 / 2 => 55
        int sum = n * (n + 1) / 2;
        System.out.println("The sum of first "+n+" natural numbers is : "+sum);

    }
}
