package com.careerit.cj.basics;

import java.util.Scanner;

public class TernaryOperatorExample {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the num1 :");
        int num1 = sc.nextInt();
        System.out.println("Enter the num2 :");
        int num2 = sc.nextInt();

        int big = (num1 > num2) ? num1 : num2;
        /*if( num1 > num2){
            big = num1;
        }else{
            big = num2;
        }*/

        System.out.println("Biggest of "+num1+" and "+num2+" is :"+big);

    }
}
