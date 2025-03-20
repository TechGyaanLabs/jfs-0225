package com.careerit.cj.abstractcls;

abstract class D1{

    D1(){
        super();
        System.out.println("D1 constructor");
    }
    abstract void m1();
    void m2(){
        System.out.println("D1 m2");
    }
    abstract  void m3();
}
abstract class D2 extends D1{
    D2(){
        super();
        System.out.println("D2 constructor");
    }
    @Override
    public void m1(){
        System.out.println("D2 m1");
    }
}
class D3 extends D2{
    D3(){
        super();
        System.out.println("D3 constructor");
    }
    @Override
    public void m3(){
        System.out.println("D3 m3");
    }
}
public class AbstractClassExample {

    public static void main(String[] args) {
        D1 obj = new D3();
    }
}
