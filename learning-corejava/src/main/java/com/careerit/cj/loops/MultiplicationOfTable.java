package com.careerit.cj.loops;

public class MultiplicationOfTable {


    public static void main(String[] args) {
       for (int num = 1; num <= 20; num++) {
            for (int i = 1; i <= 10; i++) {
                System.out.println(num + " * " + i + " = " + (num * i));
            }
            System.out.println("-".repeat(20));
       }
      }
}
