package com.careerit.cj.methods;

import java.util.Arrays;

public class MethodExample1 {

    public static void main(String[] args) {
        int[] arr = {2,3,4,5,8,6};
        MethodExample1 obj = new MethodExample1();
        int[] resultArr = obj.result(arr);
        System.out.println(Arrays.toString(resultArr));
    }

    public int sum(int a, int b) {
        return a + b;
    }

    public int mul(int a, int b) {
        return a * b;
    }
    public int biggest(int a,int b){
        return Math.max(a,b);
    }

    public int[] result(int[] arr) {
        int sumResult = 0;
        int mulResult = 1;
        int biggestResult = arr[0];
        for (int i = 0; i < arr.length; i++) {
            sumResult = sum(sumResult, arr[i]);
            mulResult = mul(mulResult, arr[i]);
            biggestResult = biggest(biggestResult,arr[i]);
        }
        return new int[]{sumResult,mulResult,biggestResult};
    }
}
