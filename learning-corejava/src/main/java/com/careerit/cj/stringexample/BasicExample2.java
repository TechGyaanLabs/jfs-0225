package com.careerit.cj.stringexample;

public class BasicExample2 {

    public static void main(String[] args) {

        String name1 = "Krishna";
        String name2 = "Krishna";

        System.out.println(name1 == name2);

        String name3 = new String("Krishna");
        String name4 = new String("Krishna");

        System.out.println(name3 == name4);

        System.out.println(name3.equals(name4));
        System.out.println(name1.equals(name3));
    }
}
