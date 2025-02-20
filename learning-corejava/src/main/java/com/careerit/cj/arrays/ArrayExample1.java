package com.careerit.cj.arrays;

public class ArrayExample1 {

    public static void main(String[] args) {

        int[] arr = new int[5];
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 40;
        arr[3] = 35;
        arr[4] = 25;

        System.out.println(arr.length);
        System.out.println(arr[2]);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println("Print element in reverse order");
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println(arr[i]);
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("Sum of all elements is " + sum);

        int big = arr[0];
        int small = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > big) {
                big = arr[i];
            }
            if (arr[i] < small) {
                small = arr[i];
            }
        }
        System.out.println("Largest element is " + big);
        System.out.println("Smallest element is " + small);
        System.out.println("Using for each loop");

        for(int num: arr){
            System.out.println(num);
        }

    }
}
