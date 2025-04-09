package com.careerit.cj.exceptionexamples;

public class ExceptionExample2 {

    public static void main(String[] args) {

        System.out.println("Start of main method");
        String name = "krish";
        System.out.println(name);
        name = null;
        try {
            System.out.println(name.toUpperCase());
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("End of main method");
    }
}
