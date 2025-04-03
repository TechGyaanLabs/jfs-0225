package com.careerit.cj.optionalexample;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MapMethodExample2 {

    public static void main(String[] args) {
        List<Integer> list =
                IntStream.rangeClosed(1,50)
                        .boxed()
                        .toList();

        System.out.println(list);

        // increment each element by 1 get numbers which are divisible by 3
        // double the number and collect the numbers which are divisible by 9

        List<Integer> result = list.stream()
                .map(i -> i + 1)
                .filter(i -> i % 3 == 0)
                .map(i -> i * 2)
                .filter(i -> i % 9 == 0)
                .collect(Collectors.toList());

        System.out.println(result);

    }
}
