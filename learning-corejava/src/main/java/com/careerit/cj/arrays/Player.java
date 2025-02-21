package com.careerit.cj.arrays;

public class Player {

    private String name;
    private String team;
    private String role;
    private String country;
    private double amount;

    public Player(String name, String team, String role, String country, double amount) {
        this.name = name;
        this.team = team;
        this.role = role;
        this.country = country;
        this.amount = amount;
    }

    public void showDetails() {
        System.out.println("Player Name: " + name);
        System.out.println("Player Team: " + team);
        System.out.println("Player Role: " + role);
        System.out.println("Player Country: " + country);
        System.out.println("Player Amount: " + amount);
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public String getRole() {
        return role;
    }

    public String getCountry() {
        return country;
    }

    public double getAmount() {
        return amount;
    }
}
