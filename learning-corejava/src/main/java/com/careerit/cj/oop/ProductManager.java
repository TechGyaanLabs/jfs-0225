package com.careerit.cj.oop;

class Product {

    private String name;
    private double price;

    public Product(String name, double price) {
       this.name = name;
       this.price = price;
    }

    public void showDetails() {
        System.out.println( "Name: " + name + ", Price: " + price);
    }
}

public class ProductManager {

    public static void main(String[] args) {

        Product p1 = new Product("iPhone 16 Pro Max", 1800000.00);
        p1.showDetails();
        Product p2 = new Product("iPhone 16 Pro", 1500000.00);
        p2.showDetails();

    }
}
