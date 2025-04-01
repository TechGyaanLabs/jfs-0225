package com.careerit.cj.setexamples;

import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
class Product{
    private int pid;
    private String name;
    private double price;

}
public class SetExample3 {

    public static void main(String[] args) {

        Product p1 = new Product(101, "iPhone", 1000);
        Product p2 = new Product(101, "iPhone", 1000);
        Product p3 = new Product(102, "Samsung", 800);
        Product p4 = new Product(103, "Sony", 700);
        Product p5 = new Product(103, "Sony", 700);

        Set<Product> set = new HashSet<>();
        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);
        set.add(p5);
        System.out.println(set.size());


    }
}
