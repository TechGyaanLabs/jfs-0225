package com.careerit.cj.mapexample;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExample1 {

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
        map.put(1001,"Krishna");
        map.put(1002,"Rajesh");
        map.put(1001,"John");

        System.out.println(map);

        Set<Integer> keys = map.keySet();
        System.out.println(keys);

        Collection<String> values = map.values();
        System.out.println(values);
        for(Integer key : keys) {
            System.out.println(key + " - " + map.get(key));
        }
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for(Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        map.forEach((k,v) -> System.out.println(k + " - " + v));
    }
}
