package com.careerit.cj.loops;

public class ContinueExample {

    public static void main(String[] args) {

        // Skip number if it is divisible by 3
        for (int i = 1; i <= 10; i++) {
            if(i % 3 == 0){
                continue;
            }
            System.out.println(i);
        }


    }
}
