package com.careerit.cj.setexamples;

import java.util.HashSet;
import java.util.Set;

public class SetExample1 {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Krishna");
        set.add("Rajesh");
        set.add("Krishna");
        set.add("Rajesh");
        set.add("Rajesh");
        set.add("John");
        set.add("Niramala");
        System.out.println(set);

        for(String name : set) {
            System.out.println(name);
        }
        set.forEach(System.out::println);


    }
}
