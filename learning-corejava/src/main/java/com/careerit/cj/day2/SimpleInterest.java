package com.careerit.cj.day2;

public class SimpleInterest {

    public static void main(String[] args) {
        float p = 10000;
        float r = 3.5f;
        float t = 2;
        float si = (p * r * t) / 100;
        System.out.println("Simple interest for amount : "+p+" for rate : "+r+" for time : "+t+" is : "+si);
    }
}
