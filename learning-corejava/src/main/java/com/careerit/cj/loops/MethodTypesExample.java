package com.careerit.cj.loops;

import java.time.LocalDateTime;

public class MethodTypesExample {

    public static void main(String[] args) {
        System.out.println(greetings("Krish"));
        System.out.println(getSystemInfo());
        showGreetings("Welcome to Java fullstack world");
        showSystemDate();
    }


    public static String greetings(String username){
        String greet = "Welcome to java world!";
        return "Hello "+username+",\n\t"+greet;
    }

    public static String getSystemInfo(){
        // Logic to get system properties
        return "MacOS-18";
    }

    public static void showGreetings(String message){
        System.out.println(message);
    }

    public static void showSystemDate(){
        System.out.println(LocalDateTime.now());
    }
}
