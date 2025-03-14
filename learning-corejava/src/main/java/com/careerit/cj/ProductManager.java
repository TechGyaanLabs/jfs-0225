package com.careerit.cj;

class Product {
    private String name;
    private double price;
    private String description;
    private double discount;

    public Product(String name, String description, double price, double discount){
       this.name = name;
       this.description = description;
       this.price = price;
       this.discount = discount;
    }

    public Product(String name,  double price, double discount){
        this(name, "N/A", price, discount);
    }
    public Product(String name,  double price){
        this(name, price, 0);
    }

    public void showDetails(){}

    @Override
    public String toString(){
        return "Name: "+name+"\nDescription: "+description+"\nPrice: "+price+"\nDiscount: "+discount;
    }
}

public class ProductManager {

    public static void main(String[] args) {

        Product p1 = new Product("Lenovo ThinkPad", "Laptop", 45000, 5000);
        Product p2 = new Product("Samsung Galaxy S10",  35000, 2000);
        Product p3 = new Product("Apple iPhone 11",  55000);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
}
