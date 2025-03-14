package com.careerit.cj;

public class IIBBlockExample {

    IIBBlockExample(){
        System.out.println("IIBBlockExample Constructor");
    }
    static{
        System.out.println("IIBBlockExample Static Block 1");
    }

    public static void main(String[] args) {
        System.out.println("IIBBlockExample Main");
        IIBBlockExample iib = new IIBBlockExample();
        IIBBlockExample iib2 = new IIBBlockExample();
    }
    {
        System.out.println("IIBBlockExample Instance Block");
    }
    static{
        System.out.println("IIBBlockExample Static Block 2");
    }
    {
        System.out.println("IIBBlockExample Instance Block 2");
    }
}
