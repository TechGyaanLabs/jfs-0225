package com.careerit.cj.inheritance;

class C1{
    void m1(){
        System.out.println("C1 m1");
    }
}
class C2 extends C1{
    void m1(){
        System.out.println("C2 m1");
    }
}
class C3 extends C2{
    void m1(){
        System.out.println("C3 m1");
    }
}
public class InheritanceExampleManager {

    public static void main(String[] args) {
        C2 obj = new C3();
        obj.m1();
    }
}
