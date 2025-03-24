package com.careerit.cj.interfaceexamples;

interface One1{
    default void m1(){
        System.out.println("One1 of m1");
    }
}
class Two2 implements One1{

    public void m1(){
        System.out.println("One1 of m2");
    }
}
public class DefaultOverrideExample {
}
