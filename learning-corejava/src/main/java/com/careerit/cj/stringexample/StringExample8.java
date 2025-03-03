package com.careerit.cj.stringexample;

public class StringExample8 {

    public static void main(String[] args) {

        StringBuilder sb1 = new StringBuilder("Hello");
        StringBuilder sb2 = new StringBuilder("Hello");

        System.out.println( sb1 == sb2);
        System.out.println(sb1.equals(sb2));

        String str1 = "Hello";
        StringBuilder sb = new StringBuilder(str1);
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
        System.out.println(isPalindrome("1238121"));
    }

    public static boolean isPalindrome(String str) {
        String revStr =  new StringBuilder(str).reverse().toString();
        return str.equals(revStr);
    }
}
