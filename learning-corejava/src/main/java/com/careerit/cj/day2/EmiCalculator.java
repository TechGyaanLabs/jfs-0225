package com.careerit.cj.day2;

public class EmiCalculator {


    public static void main(String[] args) {

        double p = 1000000;  // principal amount
        double rate = 18;   // rate of interest per annum
        double n = 36;      // n is number of months
        double r = rate / 12 / 100;  // rate of interest per month
        double emi = (p * r * (Math.pow(1 + r, n) / (Math.pow(1 + r, n) - 1)));

        double totalInterest = emi * n - p;
        double totalAmount = emi * n;

        System.out.println("Principal amount : " + p);
        System.out.println("Total interest   : " + Math.round(totalInterest));
        System.out.println("EMI              : " + Math.round(emi));
        System.out.println("Total amount     : " + Math.round(totalAmount));

    }
}
