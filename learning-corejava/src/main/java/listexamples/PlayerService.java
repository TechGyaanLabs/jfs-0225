package listexamples;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PlayerService {


    public List<String> getPlayerNames(List<Player> players) {
        /*List<String> names = new ArrayList<>();
        for(Player player:players){
            names.add(player.getName());
        }
        return names;*/
        return players.stream()
                .map(Player::getName).toList();
    }

    public List<String> getPlayerNamesByTeam(String team, List<Player> players) {
        return
                players.stream()
                        .filter(player -> player.getTeam().equals(team))
                        .map(Player::getName)
                        .toList();
    }

    public List<String> getPlayersByTeamAndStartWith(String team, String startWith, List<Player> players) {
        return
                players.stream()
                        .filter(p -> p.getTeam().equals(team))
                        .map(Player::getName)
                        .filter(name -> name.startsWith(startWith))
                        .toList();

    }

    public List<TeamAmountDto> getTeamAmountStats(List<Player> players) {
        List<String> teamNames = getTeamNames(players);
        List<TeamAmountDto> teamAmountStats = new ArrayList<>();
        for (String teamName : teamNames) {
            List<Player> teamPlayers = getPlayers(players, teamName);
            double totalAmount = getTotalAmount(teamPlayers);
            TeamAmountDto teamAmountDto = new TeamAmountDto();
            teamAmountDto.setTeam(teamName);
            teamAmountDto.setTotalAmount(totalAmount);
            teamAmountStats.add(teamAmountDto);
        }
        return teamAmountStats;
    }

    private double getTotalAmount(List<Player> players) {
        double totalAmount = 0;
        for (Player player : players) {
            totalAmount += player.getAmount();
        }
        return totalAmount;
    }

    private List<Player> getPlayers(List<Player> players, String teamName) {
        return
                players.stream()
                        .filter(p -> p.getTeam().equals(teamName))
                        .toList();
    }

    private List<String> getTeamNames(List<Player> players) {
        List<String> teamNames = new ArrayList<>();
        for (Player player : players) {
            if (!teamNames.contains(player.getTeam())) {
                teamNames.add(player.getTeam());
            }
        }
        return teamNames;

    }


}
