package com.careerit.cj.optionalexample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FlatMapExample {

    public static void main(String[] args) {

        List<String> names1 = List.of("Rajesh", "Krish", "Manoj", "Charan", "John", "Nirmala");
        List<String> names2 = List.of("Rajesh", "Krish", "Manoj", "Charan", "John", "Nirmala");
        List<String> names3 = List.of("Rajesh", "Krish", "Manoj", "Charan", "John", "Nirmala");

        List<List<String>> namesList = List.of(names1, names2, names3);

        List<String> names = namesList
                .parallelStream()
                .flatMap(List::stream)
                .toList();
        System.out.println(names);

        List<Integer> numList = List.of(1, 2, 3, 4, 5, 2, 3, 4, 5, 6, 7, 8,3, 4,7, 8,3, 4, 5, 6,7, 8, 9, 10, 11, 12, 13,7, 8, 9, 10, 11, 12, 13, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
        Map<Integer,Long> countMap =
                numList.stream()
                                .collect(Collectors.groupingBy(Function.identity(),
                                        Collectors.counting()));
        System.out.println(countMap);
    }
}
