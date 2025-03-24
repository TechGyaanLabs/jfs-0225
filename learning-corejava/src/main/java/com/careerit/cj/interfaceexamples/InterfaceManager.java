package com.careerit.cj.interfaceexamples;

import java.util.ArrayList;
import java.util.List;

interface MathInterface {
    boolean isPrime(int num);

    default int countPrime(int lb,int ub){
        return prime(lb, ub).size();
    }

    default List<Integer> prime(int lb, int ub){
        List<Integer> list = new ArrayList<>();
        for(int i = lb; i <= ub; i++) {
            if(isPrime(i)) {
                list.add(i);
            }
        }
        return list;
    }

    private int add(int a, int b) {
        return a + b;
    }
    default int sum(int... arr){
        int sum = 0;
        for(int i : arr) {
            sum = add(sum, i);
        }
        return sum;
    }

    public static int sub(int a, int b) {
        return a - b;
    }
    private static int mul(int a, int b) {
        return a * b;
    }

}

class MyMath implements MathInterface {
    @Override
    public boolean isPrime(int num) {
        if(num < 2 || (num % 2 == 0 && num != 2)) {
            return false;
        }
        for(int i = 3; i <= Math.sqrt(num); i += 2) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

public class InterfaceManager {

    public static void main(String[] args) {

        MathInterface obj = new MyMath();
        System.out.println(obj.isPrime(3));
        System.out.println(obj.countPrime(1, 20));
        System.out.println(obj.prime(1, 20));

    }
}
