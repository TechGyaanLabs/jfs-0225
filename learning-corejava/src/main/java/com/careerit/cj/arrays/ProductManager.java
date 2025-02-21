package com.careerit.cj.arrays;

public class ProductManager {

    public static void main(String[] args) {

        Product p1 = new Product("P1001","Lenovo ThinkPad",45000);
        p1.showDetails();
        System.out.println(p1.getName());
        System.out.println(p1.getPrice());
        System.out.println(p1.getPid());

    }
}
