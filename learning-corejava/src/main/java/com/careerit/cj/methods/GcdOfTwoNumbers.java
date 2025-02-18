package com.careerit.cj.methods;

public class GcdOfTwoNumbers {

    public static void main(String[] args) {
        int num1 = 18;
        int num2 = 30;
        int res = gcd(num1,num2);
        System.out.println("GCD of "+num1+" and "+num2+" is "+res);
        int num = 6;
        int fact = factorial(num);
        System.out.println("Factorial of "+num+" is "+fact);
    }
    public static int gcd(int a, int b){
        if(b != 0){
            return gcd(b,a%b);
        }
        return a;
    }
    public static int factorial(int n){
        if(n == 0 || n == 1){
            return 1;
        }
        return n * factorial(n-1);
    }
}
