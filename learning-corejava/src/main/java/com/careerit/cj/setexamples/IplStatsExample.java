package com.careerit.cj.setexamples;

import listexamples.Player;
import listexamples.SeedDataUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class IplStatsExample {

    public static void main(String[] args) {

        List<Player> players = SeedDataUtil.loadPlayers();
        Set<String> teamNames = /*new HashSet<>();
        for(Player player:players){
            teamNames.add(player.getTeam());
        }*/
        players.stream()
                .map(Player::getTeam)
                .collect(Collectors.toSet());

        System.out.println(teamNames);
    }
}
