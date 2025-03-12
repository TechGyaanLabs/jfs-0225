package com.careerit.cj.finalvariables;

class Product extends  Object{
    private String name;
    private String description;
    private int price;

    public Product(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
public class ProductManager {

    public static void main(String[] args) {

        Product p1 = new Product("P1001","Lenovo ThinkPad",45000);
        System.out.println(p1.toString());



    }
}
