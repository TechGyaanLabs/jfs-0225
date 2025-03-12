package com.careerit.cj.finalvariables;

public class OverloadingExample {

    public int add(int num1, int num2) {
        return num1 + num2;
    }

    public int add(int num1, int num2, int num3) {
        return num1 + num2 + num3;
    }
    public int add(int num1, int num2, int num3, int num4) {
        return num1 + num2 + num3 + num4;
    }

    public double add(double num1, double num2) {
        return num1 + num2;
    }

    public double add(double num1, int num2){
        return num1 + num2;
    }
    public double add(int num1, double num2){
        return num1 + num2;
    }

    public int add(int num1, int num2, int num3, int num4, int num5) {
        return num1 + num2 + num3 + num4 + num5;
    }

    public int add(int... arr){
        int sum = 0;
        for(int i:arr){
            sum += i;
        }
        return sum;
    }


    public  static final void main(final String... args) {
        OverloadingExample obj = new OverloadingExample();
        obj.add(1, 2);
        obj.add(1, 2, 3);
        obj.add(1, 2, 3, 4);
        obj.add(1, 2, 3, 4, 5);
        obj.add(1,2,3,4,5,5,6,7,8);
        obj.add(1);
        System.out.println(obj.sum(new int[]{1,2,3,4,5},new int[]{6,7,8,9,10}));
    }

    public int sum(int[]... args){
        int res = 0;
        for(int[] arr:args){
            for(int i:arr){
                res += i;
            }
        }
        return res;
    }
}
