package com.careerit.cj.abstractcls;

class C1{
    int a = 10;
    void m1(){
        System.out.println("C1 m1");
    }
}
class C2 extends C1{
    int a = 100;
    void m1(){
        System.out.println("C2 m1");
    }
    void m2(){
        System.out.println("C2 m2");
    }
}

public class TypeCastingWithReferenceDataType {
    public static void main(String[] args) {
        C1 obj = new C2();
        obj.m1();
        System.out.println(obj.a);
    }
}
