package com.careerit.cj.assignments;

import java.util.Scanner;

public class ConvertMMToMonth {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Month Number:");
        int month = sc.nextInt();
        String monthName = getMonthName(month);
        System.out.println("Month Name is: " + monthName);
    }

    private static String getMonthName(int month) {
        return "";
    }
}
