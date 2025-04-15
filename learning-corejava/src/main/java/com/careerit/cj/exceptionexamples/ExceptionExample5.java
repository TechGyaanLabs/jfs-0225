package com.careerit.cj.exceptionexamples;

import com.careerit.cj.json.Player;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExceptionExample5 {

    public static void main(String[] args) {

    }

    public double findMeanPriceOfPlayers()throws  IOException{
        throw new IOException("Error while reading players data");
    }

    public List<Player> getPlayers(String teamName){
        List<Player> players = getPlayers();
        Map<String,List<Player>> playersMap = players.stream().collect(Collectors.groupingBy(Player::getTeam));
        List<Player> playersList = playersMap.get(teamName);
        if(playersList == null){
           throw new RuntimeException("Given team name does not exist");
        }
        return playersList;
    }

    public List<Player> getPlayers() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(ExceptionExample5.class.getResourceAsStream("players.json"), new TypeReference<List<Player>>() {
            });
        }catch (IOException e){
            System.out.println("Error while reading players data");
            e.printStackTrace();
        }
        return new ArrayList<>();
    }



}
