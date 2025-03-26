package com.careerit.cj.json;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadingJson {

    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonStr = "{\"name\": \"Ruturaj Gaikwad\", \"amount\": 180000000.0, \"country\": \"Indian\", \"role\": \"Batter\", \"team\": \"CSK\"}";
            Player player = mapper.readValue(jsonStr, Player.class);
            System.out.println(player.getName());
            System.out.println(player.getCountry());
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
