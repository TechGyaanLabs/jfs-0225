package com.careerit.iplstats.service;


import com.careerit.iplstats.domain.Player;
import com.careerit.iplstats.dto.RoleCountDto;
import com.careerit.iplstats.dto.TeamAmountDto;
import com.careerit.iplstats.util.JsonUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

public class IplStatsServiceImpl implements IplStatsService {

    private static final List<Player> players;
    private static final Logger logger = LoggerFactory.getLogger(IplStatsServiceImpl.class);
    public static final String NO_PLAYERS_DATA_AVAILABLE = "No players data available";

    static{
        players = JsonUtil.loadData("/players.json",
                new TypeReference<>() {
                });
        logger.info("Total {} players loaded", players.size());
    }

    @Override
    public List<RoleCountDto> getRoleCount() {
        if(players.isEmpty()){
            logger.info(NO_PLAYERS_DATA_AVAILABLE);
            return List.of();
        }
        List<RoleCountDto> result = players
                .stream()
                .collect(Collectors.groupingBy(Player::getRole, Collectors.counting()))
                .entrySet()
                .stream()
                .map(entry -> {
                    RoleCountDto roleCountDto = new RoleCountDto();
                    roleCountDto.setRole(entry.getKey());
                    roleCountDto.setCount(entry.getValue());
                    return roleCountDto;
                }).toList();
        logger.info("Total {} roles found", result.size());
        return result;
    }

    @Override
    public List<TeamAmountDto> getTeamAmountStats() {
        if(players.isEmpty()){
            logger.info(NO_PLAYERS_DATA_AVAILABLE);
            return List.of();
        }
        
        return players
                .stream()
                .collect(Collectors.groupingBy(Player::getTeam,Collectors.summingDouble(Player::getAmount)))
                .entrySet()
                .stream()
                .map(entry -> {
                    TeamAmountDto teamAmountDto = new TeamAmountDto();
                    teamAmountDto.setTeam(entry.getKey());
                    teamAmountDto.setTotalAmount(entry.getValue());
                    return teamAmountDto;
                }).toList();
    }

    @Override
    public List<Player> getTopPaidPlayers(int n) {
        if(players.isEmpty()){
            logger.info(NO_PLAYERS_DATA_AVAILABLE);
            return List.of();
        }
        return players
                .stream()
                .sorted(Comparator.comparingDouble(Player::getAmount).reversed())
                .limit(n)
                .toList();
    }

    @Override
    public List<Player> getPlayersByTeam(String teamName) {
        if(players.isEmpty()){
            logger.info(NO_PLAYERS_DATA_AVAILABLE);
            return List.of();
        }
        return players
                .stream()
                .filter(player -> player.getTeam()
                        .equalsIgnoreCase(teamName))
                .sorted(Comparator.comparing(Player::getAmount).reversed())
                .toList();
    }

    @Override
    public List<String> getTeamNames() {
        if(players.isEmpty()){
            logger.info(NO_PLAYERS_DATA_AVAILABLE);
            return List.of();
        }
        return players
                .stream()
                .map(Player::getTeam)
                .distinct()
                .toList();
    }
}
