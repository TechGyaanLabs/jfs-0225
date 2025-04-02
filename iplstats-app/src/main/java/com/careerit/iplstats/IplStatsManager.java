package com.careerit.iplstats;

import com.careerit.iplstats.domain.Player;
import com.careerit.iplstats.dto.RoleCountDto;
import com.careerit.iplstats.dto.TeamAmountDto;
import com.careerit.iplstats.service.IplStatsService;
import com.careerit.iplstats.service.IplStatsServiceImpl;

import java.util.List;
import java.util.Scanner;

public class IplStatsManager {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to IPL Stats");
        IplStatsService iplStatsService = new IplStatsServiceImpl();

        while (true) {
            String menu = """
                    \n1. Get Role Count
                    2. Get Team Amount Stats
                    3. Get Top Paid Players
                    4. Get Players By Team
                    5. Get Team Names
                    6. Exit
                    \n""";

            System.out.println(menu);
            System.out.println("\nEnter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    List<RoleCountDto> roleCountList = iplStatsService.getRoleCount();
                    if (roleCountList.isEmpty()) {
                        System.out.println("No data available.");
                    } else {
                        roleCountList.forEach(ele->{
                            System.out.println("Role: " + ele.getRole() + ", Count: " + ele.getCount());
                        });
                    }
                }
                case 2 -> {
                    List<TeamAmountDto> teamAmountList = iplStatsService.getTeamAmountStats();
                    if (teamAmountList.isEmpty()) {
                        System.out.println("No data available.");
                    } else {
                        teamAmountList.forEach(ele->{
                            System.out.println("Team: " + ele.getTeam() + ", Total Amount: " + String.format("%.2f", ele.getTotalAmount())); //String.format("%.2f", ele.getTotalAmount());
                        });
                    }
                }
                case 3 -> {
                    System.out.println("Enter number of players to fetch: ");
                    int n = scanner.nextInt();
                    iplStatsService.getTopPaidPlayers(n)
                            .forEach(IplStatsManager::displayPlayer);
                }
                case 4 -> {
                    System.out.println("Enter team name: ");
                    String teamName = scanner.next();
                    iplStatsService.getPlayersByTeam(teamName).forEach(IplStatsManager::displayPlayer);
                }
                case 5 -> iplStatsService.getTeamNames().forEach(System.out::println);
                case 6 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
            System.out.println("Do you want to continue? (yes/no)");
            String continueChoice = scanner.next();
            if (continueChoice.equalsIgnoreCase("no")) {
                System.out.println("Exiting...");
                break;
            }

        }
    }

    private static void displayPlayer(Player ele) {
        System.out.println(ele.getName()+","+
                ele.getTeam()+","+
                ele.getRole()+","+
                ele.getCountry()+","+
                String.format("%.2f",ele.getAmount()));
    }
}
