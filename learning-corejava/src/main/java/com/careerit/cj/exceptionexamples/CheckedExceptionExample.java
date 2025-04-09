package com.careerit.cj.exceptionexamples;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.IOException;

public class CheckedExceptionExample {

    public static void main(String[] args) {
        System.out.println("Start of main method");

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode resultTree = objectMapper.readTree(CheckedExceptionExample.class.getResourceAsStream("players.json"));
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("End of main method");
    }
}
