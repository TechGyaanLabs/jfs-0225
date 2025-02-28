package com.careerit.cj.stringexample;

import java.util.Arrays;

public class StringExample5 {

    public static void main(String[] args) {

        // Anagram

        String str1 = "TAC";
        String str2 = "CAT";
        String str3 = "ACT";

        System.out.println(isAnagram(str1, str2));
        System.out.println(isAnagram(str1, str3));
        System.out.println(isAnagram(str2, "ACB"));


        int[] arr1 = new int[]{1, 5, 3, 4, 2};
        int[] arr2 = new int[]{1, 2, 5, 4, 3};
        System.out.println("Arrays.toString(arr1) :" + Arrays.toString(arr1));
        System.out.println("Arrays.toString(arr2) :" + Arrays.toString(arr2));
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        System.out.println("Arrays.toString(arr1) :" + Arrays.toString(arr1));
        System.out.println("Arrays.toString(arr2) :" + Arrays.toString(arr2));
        System.out.println("Arrays.equals(arr1, arr2) :" + Arrays.equals(arr1, arr2));

    }

    public static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }
}
