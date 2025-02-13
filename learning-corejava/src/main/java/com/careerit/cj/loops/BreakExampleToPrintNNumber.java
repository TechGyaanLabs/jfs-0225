package com.careerit.cj.loops;

public class BreakExampleToPrintNNumber {

    public static void main(String[] args) {


        // Get n numbers which divisible by 6,9

        int n = 15;
        int count = 0;
        for (int i = 1; ; i++) {
            if(i % 6 == 0 && i % 9 ==0){
                System.out.println(i+" ");
                count++;
            }

            if(n == count){
                break;
            }
        }
    }
}
