package com.careerit.cj;

class C1{
    static {
        System.out.println("C1 static block");
    }
}
class C2 extends C1{

    static {
        System.out.println("C2 static block");
    }

}
class C3 extends C2{
    public final String name = "Demo";
    static {
        System.out.println("C3 static block");
    }
}
public class IIBAndStaticExample {

    public static void main(String[] args) {

    }
}
