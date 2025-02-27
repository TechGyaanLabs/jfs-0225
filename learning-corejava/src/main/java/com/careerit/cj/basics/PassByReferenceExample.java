package com.careerit.cj.basics;

import java.util.Arrays;

public class PassByReferenceExample {

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,4,5};
        System.out.println(Arrays.toString(arr));
        increment(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void increment(int[] numArr){
        for(int i=0;i<numArr.length;i++){
            numArr[i] = numArr[i] + 1;
        }
    }
}
