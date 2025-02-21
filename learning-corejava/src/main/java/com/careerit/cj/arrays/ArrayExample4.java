package com.careerit.cj.arrays;

public class ArrayExample4 {

    public static void main(String[] args) {


        Product p1 = new Product("P1001", "Lenovo ThinkPad", 145000);
        Product p2 = new Product("P1002", "Dell Inspiron", 135000);
        Product p3 = new Product("P1003", "HP Pavilion", 155000);
        Product p4 = new Product("P1004", "Samsung Galaxy S10", 185000);
        Product p5 = new Product("P1005", "Apple iPhone X", 155000);

        Product[] products = new Product[]{p1, p2, p3, p4, p5};

        // Show products details

        for (Product product : products) {
            product.showDetails();
            System.out.println("-".repeat(35));
        }

        // totalPrice, maxPrice, minPrice price of all products

        double totalPrice = 0;
        double maxPrice = products[0].getPrice();
        double minPrice = products[0].getPrice();

        for (Product product : products) {
            totalPrice += product.getPrice();
            if (product.getPrice() > maxPrice) {
                maxPrice = product.getPrice();
            }
            if (product.getPrice() < minPrice) {
                minPrice = product.getPrice();
            }
        }

        System.out.println("Total Price: " + totalPrice);
        System.out.println("Max Price: " + maxPrice);
        System.out.println("Min Price: " + minPrice);


        // Show Max Priced Product(s) Details

        System.out.println("\nMax Priced Product(s) Details:\n");

        for(Product product:products){

                if(product.getPrice()==maxPrice){
                    product.showDetails();
                    System.out.println("-".repeat(35));
                }
        }

        // Get products price is <=100000 and show details of those products
        System.out.println("\nProducts price is <=100000 and show details of those products:\n");
        boolean flag=false;
        for(Product product:products){
            if(product.getPrice()<=100000){
                product.showDetails();
                System.out.println("-".repeat(35));
                flag=true;
            }
        }
        if(!flag){
            System.out.println("No products price is <=100000");
        }


    }
}
