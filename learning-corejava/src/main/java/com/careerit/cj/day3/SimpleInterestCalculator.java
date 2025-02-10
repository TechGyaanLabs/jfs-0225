package com.careerit.cj.day3;

import java.util.Scanner;

public class SimpleInterestCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the principal amount :");
        double p = sc.nextDouble();
        System.out.println("Enter the rate of interest :");
        double r = sc.nextDouble();
        System.out.println("Enter the time in months :");
        double t = sc.nextDouble();

        double si = (p * t * r) / 100;

        System.out.println("Simple interest for amount : "+p+" for rate : "+r+" for time : "+t+" is : "+si);
    }
}
