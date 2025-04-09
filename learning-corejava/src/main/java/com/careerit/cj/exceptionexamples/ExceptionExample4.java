package com.careerit.cj.exceptionexamples;

public class ExceptionExample4 {

    public static void main(String[] args) {
        System.out.println("Start of main method");
        try {
            String name = "krish";
            System.out.println(name);
            name = null;
            System.out.println(name.toUpperCase());
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Null pointer exception");
        } finally {
            System.out.println("Finally block");
        }
        System.out.println("End of main method");
    }
}
