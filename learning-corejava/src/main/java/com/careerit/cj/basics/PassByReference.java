package com.careerit.cj.basics;

class Product {

    int id;
    String name;
    double price;
    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public void display() {
        System.out.println("Product ID: "+id);
        System.out.println("Product Name: "+name);
        System.out.println("Product Price: "+price);
        System.out.println();
    }
}
public class PassByReference {

    public static void main(String[] args) {
        Product p1 = new Product(101, "Laptop", 100000.00);
        Product p2 = new Product(102, "Mobile", 50000.00);
        Product p3 = p1;
        Product p4 = p1;
        increment(p1);
        p3.display();
    }

    public static void increment(Product p) {
        p.price = 150000.00;
    }
}
