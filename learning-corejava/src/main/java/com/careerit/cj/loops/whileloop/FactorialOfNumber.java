package com.careerit.cj.loops.whileloop;

import java.util.Scanner;

public class FactorialOfNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the num :");
        int num = sc.nextInt();

        int i = 1;
        int fact = 1;
        while(i <= num){
            fact *= i;
            i++;
        }

        System.out.println("Factorial of "+num+" is "+fact);
    }
}
