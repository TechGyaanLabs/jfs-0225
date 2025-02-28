package com.careerit.cj.stringexample;

import java.util.Arrays;

public class StringExample3 {

    public static void main(String[] args) {

        // String split method
       String namesData = "Krish,Rajesh,Raju,John Doe,Niramala";

       String[] names = namesData.split(",");
       for(String name:names) {
    	   System.out.println(name);
       }

       String str = "foo:bar:foo";

       String[] tokens = str.split(":");
       System.out.println(tokens.length);

       String str1 = "kiniiing";
       String[] tokens1 = str1.split("i");
       System.out.println(Arrays.toString(tokens1));
       System.out.println(tokens1.length);

       String customerData = "1456-Manoj-91-11,3456-Charan-91-10,2345-Rajesh-1-11,3436-Krishna-12-12";

       String[] customerArr = customerData.split(",");
       for(String customer:customerArr) {
    	   String[] custArr = customer.split("-");
    	   System.out.println(custArr[1]);
       }
    }

}
