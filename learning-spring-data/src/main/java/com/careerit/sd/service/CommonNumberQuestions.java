package com.careerit.sd.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommonNumberQuestions {

    public int biggest(int a,int b, int c){
        return Math.max(a, Math.max(b, c));
    }

    public int smallest(int a,int b, int c){
        return 0;
    }

    public int primeCount(int lb,int ub){
        return 0;
    }
    public List<Integer> getPrimes(int lb,int ub){
        return null;
    }

    public int gcd(int a, int b){
        return 0;
    }

    public int lcm(int a, int b){
        return 0;
    }

    public int factorial(int n){
        return 0;
    }

    public int sumOfDigits(int n){
        return 0;
    }

    public int reverse(int n){
        return 0;
    }

    public int isArmstrong(int n){
        return 0;
    }

    public int isPalindrome(int n){
        return 0;
    }

    public int isPerfect(int n){
        return 0;
    }

    public int isFibonacci(int n){
        return 0;
    }
}
