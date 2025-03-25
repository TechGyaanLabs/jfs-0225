package com.careerit.cj.collections;

import java.util.ArrayList;
import java.util.List;

public class ListExample2 {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(100);
        list.add(200);
        list.add(300);
        list.add(400);
        list.add(500);
        list.add(400);
        list.add(500);

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

        System.out.println("Reverse order");

        for(int i=list.size()-1;i>=0;i--){
            System.out.println(list.get(i));
        }
        System.out.println(list);
        list.remove(2);
        list.remove(Integer.valueOf(400));
        System.out.println(list);

        System.out.println(list.isEmpty());
    }
}
