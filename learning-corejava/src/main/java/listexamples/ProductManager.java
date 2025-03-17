package listexamples;

import java.util.ArrayList;
import java.util.List;

class Product {
    private String pid;
    private String name;
    private double price;

    public Product(String pid, String name, double price) {
        this.pid = pid;
        this.name = name;
        this.price = price;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid='" + pid + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
public class ProductManager {

    public static void main(String[] args) {

       String data = """
            P1001,iPhone 16 Pro,120000.00-
            P1002,iPhone 13 Pro Max,150000.00-
            P1003,iPhone 14 Pro,180000.00-
            P1004,iPhone 15 Pro,210000.00-
            P1005,iPhone 16 Pro Max,240000.00
        """;

       String[] arr = data.split("-");
       List<Product> products = new ArrayList<>();
       for(String s: arr){
           String productStr = s.trim();
           String[] productArr = productStr.split(",");
           String pid = productArr[0];
           String name = productArr[1];
           double price = Double.parseDouble(productArr[2]);
           Product product = new Product(pid, name, price);
           products.add(product);
       }
       for(Product p: products){
           System.out.println(p);
       }

       // Get only product names as list

        List<String> productNames = new ArrayList<>();

       for(Product p: products){
           productNames.add(p.getName());
       }
       System.out.println(productNames);

       // Show me the count,sum and avg price of all products.

       int count = products.size();
       double totalPrice = 0;

       for(Product p: products){
           totalPrice += p.getPrice();
       }
       double avgPrice = totalPrice/count;

       System.out.println("Total Products: "+count);
       System.out.println("Total Price: "+totalPrice);
       System.out.println("Average Price: "+avgPrice);

    }
}
