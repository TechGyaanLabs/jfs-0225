package com.careerit.cj.exceptionexamples;

import java.util.Scanner;

public class ExceptionExample1 {

    public static void main(String[] args) {
        System.out.println("Start of main method");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the num1 :");
        int num1 = sc.nextInt();
        System.out.println("Enter the num2 :");
        int num2 = sc.nextInt();
        try {
            int res = num1 / num2;
            System.out.println("Result is : " + res);
        }catch (ArithmeticException e){
            System.out.println("You are trying to divide by zero");
            e.printStackTrace();
        }
        System.out.println("End of main method");
    }
}
