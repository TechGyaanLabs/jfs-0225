package com.careerit.cj.iplstats.dao;

import com.careerit.cj.iplstats.dto.RoleCountDto;
import com.careerit.cj.iplstats.dto.TeamAmountDto;
import com.careerit.cj.iplstats.dto.TeamNameDto;
import com.careerit.cj.jdbc.Player;

import java.util.List;

public interface IplStatsDao {

        List<TeamAmountDto> getTeamAmountStats();
        List<RoleCountDto> getRoleCountStats();
        TeamNameDto getTeamNames();
        List<Player> getPlayerNamesByTeam(String team);
        List<Player> top5AmountsPaidPlayers();


}
