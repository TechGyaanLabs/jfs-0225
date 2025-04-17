package com.careerit.cj.iplstats.dao;

import com.careerit.cj.iplstats.dto.RoleCountDto;
import com.careerit.cj.iplstats.dto.TeamAmountDto;
import com.careerit.cj.iplstats.dto.TeamNameDto;
import com.careerit.cj.jdbc.Player;

import java.util.List;

public class IplStatsDaoImpl implements IplStatsDao {
    @Override
    public List<TeamAmountDto> getTeamAmountStats() {
        return List.of();
    }

    @Override
    public List<RoleCountDto> getRoleCountStats() {
        return List.of();
    }

    @Override
    public TeamNameDto getTeamNames() {
        return null;
    }

    @Override
    public List<Player> getPlayerNamesByTeam(String team) {
        return List.of();
    }

    @Override
    public List<Player> top5AmountsPaidPlayers() {
        return List.of();
    }
}
