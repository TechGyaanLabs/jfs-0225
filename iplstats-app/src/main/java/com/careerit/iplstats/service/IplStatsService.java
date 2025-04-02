package com.careerit.iplstats.service;

import com.careerit.iplstats.domain.Player;
import com.careerit.iplstats.dto.RoleCountDto;
import com.careerit.iplstats.dto.TeamAmountDto;

import java.util.List;

public interface IplStatsService {
    List<RoleCountDto> getRoleCount();
    List<TeamAmountDto> getTeamAmountStats();
    List<Player> getTopPaidPlayers(int n);
    List<Player> getPlayersByTeam(String teamName);
    List<String> getTeamNames();
}
