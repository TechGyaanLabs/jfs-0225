package com.careerit.cj.staticexample;

import java.util.Arrays;

public class StaticExample1 {

    public void showGreetings() {
        System.out.println("Welcome to Java World");
    }

    public static final  void main(final String... args) {

        System.out.println(Arrays.toString(args));
        // "2.5"
        int value1 = Integer.parseInt(args[1]);
        int value2 = Integer.parseInt(args[2]);
        double value = Double.parseDouble(args[4]);
        System.out.println(value1);
        System.out.println(value2);
        System.out.println(value);
        double result = Math.sqrt(89);
        System.out.println(result);

        StaticExample1 obj = new StaticExample1();
        obj.showGreetings();
    }
}
