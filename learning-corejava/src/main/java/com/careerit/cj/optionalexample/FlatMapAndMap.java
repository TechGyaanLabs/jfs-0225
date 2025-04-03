package com.careerit.cj.optionalexample;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FlatMapAndMap {

    public static void main(String[] args) {
        String names = "Rajesh,Krish,Manoj,Charan,John,Nirmala";

        List<String> namesList = List.of(names.split(","));
        System.out.println(namesList);

        List<Integer> namesLengthList =
                namesList.
                        stream().
                        map(String::length).
                        toList();
        System.out.println(namesLengthList);

    }
}
