package com.careerit.cj.staticexample;

class D1{
    static {
        System.out.println("D1 static block is executed");
    }
    static int resOfD1 = 10;
}
class D2 {
    static {
        System.out.println("D2 static block is executed");
    }
    static int resOfD2 = 20;
}
public class StaticBlockExample1 {

    static {
        System.out.println("Static block is executed");
    }
    public static void main(String[] args) {
        System.out.println(D1.resOfD1);
        System.out.println(D2.resOfD2);
        System.out.println(D1.resOfD1);
        System.out.println(D2.resOfD2);
    }
}
