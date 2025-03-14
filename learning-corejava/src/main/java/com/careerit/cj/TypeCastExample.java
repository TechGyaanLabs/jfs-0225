package com.careerit.cj;

public class TypeCastExample {

    public static void main(String[] args) {

        // Type casting: It is process of converting one data to another valid data type
        int i = 10;
        double d = i; // implicit type casting.
        System.out.println(d);

        double e = 10.5;
        int j = (int)e; // explicit type casting
        System.out.println(j);

        String regNo = "3090.89";
        double num = Double.parseDouble(regNo);
        System.out.println(num);

        String data = "Rajesh-30-Bengaluru-560070";
        String[] arr = data.split("-");
        String name = arr[0];
        int age = Integer.parseInt(arr[1]);
        String city = arr[2];
        long code = Long.parseLong(arr[3]);
        System.out.println(name + " " + age + " " + city + " " + code);


        // Boxing and un-boxing

        int num1 = 10;
        Integer num2 = num1; // Boxing
        int num3 = num2; // Un-boxing

        double num4 = 10.50000;
        double num5 = 10.5100;
        System.out.println( num4);
        System.out.println(num5);


    }
}
