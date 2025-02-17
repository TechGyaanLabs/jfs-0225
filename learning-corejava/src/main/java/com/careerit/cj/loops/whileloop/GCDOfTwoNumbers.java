package com.careerit.cj.loops.whileloop;

public class GCDOfTwoNumbers {

    public static void main(String[] args) {

            int num1 = 18;
            int num2 = 30;

            int res = gcd(num1,num2);
            System.out.println(res);

    }

    public static int gcd(int a,int b){

        while(b != 0){
            int temp = b;
            b  = a % b;
            a = temp;
        }
        return a;
    }
}
