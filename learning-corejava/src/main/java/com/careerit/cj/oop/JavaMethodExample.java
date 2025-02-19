package com.careerit.cj.oop;

import javax.naming.OperationNotSupportedException;

public class JavaMethodExample {


    public static void main(String[] args) {
            JavaMethodExample obj = new JavaMethodExample();
            int res = obj.add (10,30);
            obj.showSystemDetails();

    }

    public int add(int a, int b) {
        return a + b;
    }

    public void showSystemDetails() {
        System.out.println("Java version is "+System.getProperty("java.version"));
        System.out.println("Java home is "+System.getProperty("java.home"));
        System.out.println( "OS name is "+System.getProperty("os.name"));
    }

    public static double divide(double a, double b)throws OperationNotSupportedException {
        throw new OperationNotSupportedException("Divide by zero");
    }
}
