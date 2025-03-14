package com.careerit.cj.inheritance;

import java.util.ArrayList;
import java.util.List;

class A {
    A() {
        System.out.println("A");
    }
}

class B extends A {
    B(int num) {
        System.out.println("B");
    }
}

class C extends B {
    C() {
        super(10);
        System.out.println("C");
    }
}

public class SuperKeyWordExample {

    public static void main(String[] args) {
        A obj = new C();


    }
}
