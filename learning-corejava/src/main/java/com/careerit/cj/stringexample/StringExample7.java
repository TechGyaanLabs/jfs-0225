package com.careerit.cj.stringexample;


public class StringExample7 {

    public static void main(String[] args) {

            Product[] products = getProducts();

            String str = "Name,Price,Quantity,Category,Description";
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            for(Product p:products) {
               sb.append("\n")
                       .append(p.getName())
                                           .append(",")
                                           .append(p.getPrice())
                                           .append(",")
                                           .append(p.getQuantity())
                                           .append(",")
                                           .append(p.getCategory())
                                           .append(",")
                                           .append(p.getDescription());

            }
            System.out.println(sb.toString());


             String str1 = "Hello";
             str1 = str1.concat(" World");
             System.out.println(str1);

             String name = "Krish";
             String greetings = "Hello "+name+" Good Morning";
             System.out.println(greetings);

             StringBuilder sb1 = new StringBuilder();
             sb1.append("Hello ").append("Krish").append(" Good Morning");
             System.out.println(sb1.toString());


    }

    public static Product[] getProducts() {

        Product p1 = new Product("iPhone16",120000,1,"Mobile","Gold color with 256GB");
        Product p2 = new Product("Samsung10",100000,1,"Mobile","White color with 128GB");
        Product p3 = new Product("Sony10",150000,1,"TV","White color with 4K");
        Product p4 = new Product("LG10",150000,1,"TV","White color with 4K");
        Product p5 = new Product("MacAirPro",750000,1,"Laptop","White color with 4K");
        return new Product[]{p1,p2,p3,p4,p5};

    }
}
