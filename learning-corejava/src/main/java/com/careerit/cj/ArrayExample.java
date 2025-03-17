package com.careerit.cj;

import java.util.Arrays;

public class ArrayExample {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        int[] arr1 = new int[5];
        arr1[0] = 10;
        arr1[1] = 20;
        arr1[2] = 30;
        arr1[3] = 40;
        arr1[4] = 50;
        System.out.println(Arrays.toString(arr1));
        int[] arr2 = new int[]{10, 20, 30, 40, 50};

        int[] arr3 = new int[arr1.length + arr2.length];

        System.arraycopy(arr1, 0, arr3, 0, arr1.length);
        System.arraycopy(arr2, 0, arr3, arr1.length, arr2.length);
        System.out.println(Arrays.toString(arr3));


    }
}
