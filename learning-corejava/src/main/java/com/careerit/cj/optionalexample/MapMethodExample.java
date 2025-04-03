package com.careerit.cj.optionalexample;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


record Person(String name, int age, String city) {
}

public class MapMethodExample {

    public static void main(String[] args) {
        Person p1 = new Person("John", 25, "New York");
        Person p2 = new Person("Kiran", 30, "Hyderabad");
        Person p3 = new Person("Ravi", 35, "Bangalore");
        Person p4 = new Person("Ravi", 35, "Bangalore");
        Person p5 = new Person("Ravi", 35, "Bangalore");
        Person p6 = new Person("Krishna", 35,"Hyderabad");
        Person p7 = new Person("Charan", 35, "Bangalore");
        Person p8 = new Person("Ravi Teja", 35, "Hyderabad");

        List<Person> personList = List.of(p1, p2, p3, p4, p5, p6, p7, p8);
        List<String> names =
                personList.stream()
                        .map(Person::name)
                        .toList();
        System.out.println(names);

        Map<String,Long> countMap =
                personList.stream()
                        .collect(Collectors.groupingBy(Person::city,
                                Collectors.counting()));
        System.out.println(countMap);


    }
}
