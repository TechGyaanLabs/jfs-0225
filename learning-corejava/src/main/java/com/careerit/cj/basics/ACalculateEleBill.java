package com.careerit.cj.basics;

import java.util.Scanner;

public class ACalculateEleBill {

    public static void main(String[] args) {

        double baseAmount = 100;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of units :");
        int units = sc.nextInt();

        // if units >= 1  and <= 100 then unit charge is 1.5
        // if units > 100 and <= 200 then unit charge is 2
        // if units > 200 and <= 300 then unit charge is 3
        // if units > 300 then unit charge is 5

        // Calculate the total amount (units * unit price + base amount)  and print it.

    }
}
