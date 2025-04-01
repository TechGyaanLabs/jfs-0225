package com.careerit.cj.mapexample;

import java.util.HashMap;
import java.util.Map;

public class WordCountExample {

    public static void main(String[] args) {

        String data = "I am learning Java and learning Java is fun to have fun learn Java in fun way";
        String[] words = data.split(" ");
        Map<String,Integer> wordCountMap = new HashMap<>();

        for(String word : words){
            wordCountMap.put(word,
                    wordCountMap.getOrDefault(word,0)+1);
        }
        System.out.println(wordCountMap);
        System.out.println(wordCountMap.getOrDefault("Java",0));
    }
}
