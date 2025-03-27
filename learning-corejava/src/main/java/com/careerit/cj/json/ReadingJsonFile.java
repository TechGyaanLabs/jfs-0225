package com.careerit.cj.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadingJsonFile {

    public static void main(String[] args) {
        ReadingJsonFile obj = new ReadingJsonFile();
        List<Player> players = obj.getPlayers();
        System.out.println("Total players count is: "+players.size());
    }


    public List<Player> getPlayers(){
        List<Player> list = new ArrayList<>();
        try{
            ObjectMapper mapper = new ObjectMapper();
            list = mapper.readValue(this.getClass().getResourceAsStream("/players.json"), new TypeReference<List<Player>>() {});
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        return list;
    }
}
