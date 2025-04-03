package com.careerit.cj.optionalexample;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalExample1 {

    public static void main(String[] args) {

       String name = "ravi";
       Optional<String> searchName = searchName(name);
       if(searchName.isPresent()){
           System.out.println(searchName.get().toUpperCase());
       }else{
           System.out.println("Name not found");
       }
    }

    private static Optional<String> searchName(String name) {
        List<String> names = getNames();
        String result = null;
        for(String n:names){
            if(n.equalsIgnoreCase(name)){
                result = n;
                break;
            }
        }
        return Optional.ofNullable(result);
    }

    private static List<String> getNames() {
        return List.of("John", "Kiran", "Ravi", "Rajesh");
    }
}
