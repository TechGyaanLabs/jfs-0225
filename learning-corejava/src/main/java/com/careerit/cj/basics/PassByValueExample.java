package com.careerit.cj.basics;

public class PassByValueExample {

    public static void main(String[] args) {
        int num = 10;
        System.out.println(num);
        increment(num);
        System.out.println(num);

        int a = 10;
        int b = 20;
        System.out.println("Before swap: a = " + a + " b = " + b);
        swap(a,b);

    }

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("After swap: a = " + a + " b = " + b);
    }

    public static void increment(int num) {
        num = num + 1;
        System.out.println(num);
    }
}
