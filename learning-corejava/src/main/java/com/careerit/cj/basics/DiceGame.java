package com.careerit.cj.basics;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class DiceGame {

    public static void main(String[] args) {

        int generatedNum = ThreadLocalRandom.current().nextInt(1, 7);
        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= 3; i++) {
            System.out.println("Guess number (1-6)");
            int guessedNum = sc.nextInt();
            if (generatedNum == guessedNum) {
                System.out.println("Good you guessed number in "+i+" attempts ");
                break;
            } else{
                if(i==3){
                    System.out.println("You reached max number of attempts, the number is "+generatedNum);
                }else {
                    System.out.println("You guessed number is wrong, try again : you have "+(3-i)+ " attempts");
                }
            }
        }
    }
}
