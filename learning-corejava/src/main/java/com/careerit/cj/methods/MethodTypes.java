package com.careerit.cj.methods;

public class MethodTypes {

    public static void main(String[] args) {

        greetings("Krishna");
        MethodTypes mt = new MethodTypes();
        mt.showGreeting("Krishna");
    }

    public static void greetings(String name) {
        System.out.println("Hello "+name);
    }

    public void showGreeting(String name) {
        System.out.println("Hello "+name);
    }
}
