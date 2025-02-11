package com.careerit.cj.basics;

import java.util.Scanner;

public class GradeExample {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the marks of the student :");
        int score = sc.nextInt();

        if(score >=9 && score <= 10) {
            System.out.println("Grade A");
        }else if(score >= 6 && score <= 8) {
            System.out.println("Grade B");
        }else if(score >= 3 && score <= 5) {
            System.out.println("Grade C");
        }else if(score >= 0 && score <= 2) {
            System.out.println("Grade D");
        }else{
            System.out.println("Invalid score");
        }

    }
}
