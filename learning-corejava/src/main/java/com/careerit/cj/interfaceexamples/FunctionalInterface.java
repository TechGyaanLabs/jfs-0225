package com.careerit.cj.interfaceexamples;

@java.lang.FunctionalInterface
interface One{
    void m1();
}
@java.lang.FunctionalInterface
interface  Two{
    void m1();
    default void m2(){
        System.out.println("M2");
    }
    private void m3(){
        System.out.println("M3");
    }
    public static void m4(){
        System.out.println("M4");
    }
    private static void m5(){
        System.out.println("M5");
    }
}

interface  Three{
    void m1();
    void m2();
}

// Marker interface

interface Four{

}

public class FunctionalInterface {
}
