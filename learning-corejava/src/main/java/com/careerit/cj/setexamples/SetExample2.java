package com.careerit.cj.setexamples;

import java.util.HashSet;
import java.util.Set;

public class SetExample2 {

    public static void main(String[] args) {

        String data = "Krishna, Rajesh, John, Niramala, Krishna, Rajesh, John, Niramala";
        String[] arr = data.split(",");

        Set<String> set = new HashSet<>();
        for (String name : arr) {
            set.add(name.trim());
        }
        System.out.println(set);
    }
}
