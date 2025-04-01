package com.careerit.cj.mapexample;

import listexamples.Player;
import listexamples.SeedDataUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MapExample2 {

    public static void main(String[] args) {

        List<Player> players = SeedDataUtil.loadPlayers();
        // TeamName -> List of Players
        Map<String, List<Player>> map =
                players.stream()
                        .collect(Collectors.groupingBy(Player::getTeam));

        map.forEach((k,v) ->
                System.out.println("Team " + k + " has " + v.size()+" players"));
    }
}
