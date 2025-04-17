package com.careerit.cj.iplstats;

import com.careerit.cj.iplstats.dao.IplStatsDao;
import com.careerit.cj.iplstats.dao.IplStatsDaoImpl;
import com.careerit.cj.iplstats.dto.RoleCountDto;
import com.careerit.cj.iplstats.dto.TeamAmountDto;
import com.careerit.cj.iplstats.dto.TeamNameDto;
import com.careerit.cj.jdbc.Player;

import java.util.List;
import java.util.Scanner;

public class IplStatsManager {

    public static void main(String[] args) {
        IplStatsDao dao = new IplStatsDaoImpl();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- IPL Stats Menu ---");
            System.out.println("1. Get Team Amount Stats");
            System.out.println("2. Get Role Count Stats");
            System.out.println("3. Get Team Names");
            System.out.println("4. Get Players by Team");
            System.out.println("5. Get Top 5 Paid Players");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    List<TeamAmountDto> teamAmountStats = dao.getTeamAmountStats();
                    teamAmountStats.forEach(stat ->
                            System.out.println("Team: " + stat.getTeam() + ", Total Amount: " + stat.getAmount()));
                }
                case 2 -> {
                    List<RoleCountDto> roleCountStats = dao.getRoleCountStats();
                    roleCountStats.forEach(stat ->
                            System.out.println("Role: " + stat.getRole() + ", Count: " + stat.getCount()));
                }
                case 3 -> {
                    TeamNameDto teamNames = dao.getTeamNames();
                    System.out.println("Teams: " + String.join(", ", teamNames.getTeamName()));
                }
                case 4 -> {
                    System.out.print("Enter team name: ");
                    String teamName = sc.nextLine();
                    List<Player> players = dao.getPlayerNamesByTeam(teamName);
                    players.forEach(player ->
                            System.out.println("Name: " + player.getName() + ", Amount: " + player.getAmount()));
                }
                case 5 -> {
                    List<Player> topPlayers = dao.top5AmountsPaidPlayers();
                    topPlayers.forEach(player ->
                            System.out.println("Name: " + player.getName() + ", Amount: " + player.getAmount()));
                }
                case 6 -> {
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}