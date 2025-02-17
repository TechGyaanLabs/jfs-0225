package com.careerit.cj.loops.whileloop;

import java.util.Scanner;

public class SwitchExample1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the num1 :");
        int num1 = sc.nextInt();
        System.out.println("Enter the num2 :");
        int num2 = sc.nextInt();
        System.out.println("1.Add 2.Sub 3.Mul 4.Div 5.Mod 6.Exit");
        System.out.println("Enter the choice :");
        int ch = sc.nextInt();
        switch (ch) {
            case 1 -> {
                int res = num1 + num2;
                System.out.println(num1 + " + " + num2 + " = " + res);
            }
            case 2 -> {
                int res = num1 - num2;
                System.out.println(num1 + " - " + num2 + " = " + res);
            }
            case 3 -> {
                int res = num1 * num2;
                System.out.println(num1 + " * " + num2 + " = " + res);
            }
            case 4 -> {
                int res = num1 / num2;
                System.out.println(num1 + " / " + num2 + " = " + res);
            }
            case 5 -> {
                int res = num1 % num2;
                System.out.println(num1 + " % " + num2 + " = " + res);
            }
            default -> System.out.println("Thank you.");
        }

    }
}
