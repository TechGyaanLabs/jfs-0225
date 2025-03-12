package com.careerit.cj.staticexample;
import java.io.PrintStream;
import java.io.PrintWriter;

import static com.careerit.cj.staticexample.C1.*;
import static com.careerit.cj.staticexample.C2.*;
class C1{

    public static void m1(){
        System.out.println("C1 of M1");
    }
    public static void m2(){
        System.out.println("C1 of M2");
    }
}
class C2{
    public static void m1(){
        System.out.println("C2 of M1");
    }
    public static void m3(){
        System.out.println("C2 of M3");
    }
}
public class StaticImportExample2 {

    public static void main(String[] args) {

            C1.m1();
            m2();
            C2.m1();
            m3();
            CareerIt.out.println("Hello World");


    }
}

class CareerIt{
    public static PrintStream out = System.out;

}
