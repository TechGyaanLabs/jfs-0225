package com.careerit.cj.arrays;

public class Product {

    private String pid;
    private String name;
    private double price;

    public Product(String pid, String name, double price) {
        this.pid = pid;
        this.name = name;
        this.price = price;
    }

    public void showDetails(){
        System.out.println("Product ID: "+pid);
        System.out.println("Product Name: "+name);
        System.out.println("Product Price: "+price);
    }

    public String getPid() {
        return pid;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
