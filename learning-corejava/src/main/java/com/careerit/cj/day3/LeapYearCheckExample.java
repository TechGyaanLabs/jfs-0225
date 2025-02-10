package com.careerit.cj.day3;

import java.sql.SQLOutput;
import java.util.Scanner;

public class LeapYearCheckExample {

    public static void main(String[] args) {

        /*Scanner sc = new Scanner(System.in);
        System.out.println("Enter the year :");
        int year = sc.nextInt();*/

        // What is a leap year?
        // A year is a leap year if it is divisible by 4 and not divisible by 100 or divisible by 400

        // Print leap years 1980 to 2040 (both inclusive)
        for (int year = 1980; year <= 2040; year++) {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                System.out.println(year + " is a leap year");
            } else {
                System.out.println(year + " is not a leap year");
            }
        }


    }
}
