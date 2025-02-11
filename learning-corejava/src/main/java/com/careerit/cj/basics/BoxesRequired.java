package com.careerit.cj.basics;

import java.util.Scanner;

public class BoxesRequired {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total items :");
        int totalItems = sc.nextInt();
        System.out.println("Enter the box capacity :");
        int boxCapacity = sc.nextInt();

        int boxes = totalItems / boxCapacity;

        if (totalItems % boxCapacity != 0) {
            boxes += 1;
        }

        System.out.println("The number of boxes required to pack " + totalItems + " items is : " + boxes);
    }
}
