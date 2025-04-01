package com.careerit.cj.mapexample;

import listexamples.Player;
import listexamples.SeedDataUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapExample3 {

    public static void main(String[] args) {
        List<Player> players = SeedDataUtil.loadPlayers();

        Map<String,Integer> playerCountMap = new HashMap<>();
        // Count of indian players and outside players

        Map<String,List<Player>> playerByRoleMap = new HashMap<>();
        // Key as role and value as list of players

        Map<String,Map<String,List<Player>>> teamRolePlayerMap = new HashMap<>();
        // Key as team name and value as map of role and list of players
    }
}
