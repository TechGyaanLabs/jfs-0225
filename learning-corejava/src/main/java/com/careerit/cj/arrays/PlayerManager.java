package com.careerit.cj.arrays;

public class PlayerManager {

    public static void main(String[] args) {

        // Show all player details


        // Show Max Paid Player(s) details


        // Show Player details of given team name


        // Show all team name only


        // Show total player, total amount ,max amount, min amount of given team

    }

    public static Player[] getPlayers() {
        Player[] players = new Player[]{
                new Player("Ruturaj Gaikwad", "CSK", "BATSMAN", "India", 18.0),
                new Player("Ravindra Jadeja", "CSK", "ALL_ROUNDER", "India", 18.0),
                new Player("Matheesha Pathirana", "CSK", "BOWLER", "Sri Lanka", 13.0),
                new Player("Shivam Dube", "CSK", "BATSMAN", "India", 12.0),
                new Player("MS Dhoni", "CSK", "WICKETKEEPER", "India", 4.0),
                new Player("Devon Conway", "CSK", "BATSMAN", "New Zealand", 6.25),
                new Player("Rahul Tripathi", "CSK", "BATSMAN", "India", 3.4),
                new Player("Rachin Ravindra", "CSK", "ALL_ROUNDER", "New Zealand", 4.0),
                new Player("Ravichandran Ashwin", "CSK", "BOWLER", "India", 9.75),
                new Player("Syed Khaleel Ahmed", "CSK", "BOWLER", "India", 4.8),
                new Player("Noor Ahmad", "CSK", "BOWLER", "Afghanistan", 10.0),
                new Player("Vijay Shankar", "CSK", "ALL_ROUNDER", "India", 1.2),
                new Player("Sam Curran", "CSK", "ALL_ROUNDER", "England", 2.4),
                new Player("Jamie Overton", "CSK", "ALL_ROUNDER", "England", 1.5),
                new Player("Shreyas Gopal", "CSK", "BOWLER", "India", 0.3),
                new Player("Vansh Bedi", "CSK", "BATSMAN", "India", 0.55),
                new Player("C Andre Siddarth", "CSK", "BATSMAN", "India", 0.3),
                new Player("Axar Patel", "DC", "BOWLER", "India", 16.5),
                new Player("Kuldeep Yadav", "DC", "BOWLER", "India", 13.25),
                new Player("Tristan Stubbs", "DC", "BATSMAN", "South Africa", 10.0),
                new Player("Abishek Porel", "DC", "WICKETKEEPER", "India", 4.0),
                new Player("Mitchell Starc", "DC", "BOWLER", "Australia", 11.75),
                new Player("KL Rahul", "DC", "WICKETKEEPER", "India", 14.0),
                new Player("Harry Brook", "DC", "BATSMAN", "England", 6.25),
                new Player("Jake Fraser-Mcgurk", "DC", "BATSMAN", "Australia", 9.0),
                new Player("T Natarajan", "DC", "BOWLER", "India", 10.75),
                new Player("Karun Nair", "DC", "BATSMAN", "India", 0.5),
                new Player("Sameer Rizvi", "DC", "ALL_ROUNDER", "India", 0.95),
                new Player("Ashutosh Sharma", "DC", "ALL_ROUNDER", "India", 3.8),
                new Player("Mohit Sharma", "DC", "BOWLER", "India", 2.2),
                new Player("Faf du Plessis", "DC", "BATSMAN", "South Africa", 2.0),
                new Player("Mukesh Kumar", "DC", "BOWLER", "India", 8.0),
                new Player("Darshan Nalkande", "DC", "ALL_ROUNDER", "India", 0.3),
                new Player("Vipraj Nigam", "DC", "ALL_ROUNDER", "India", 0.5),
                new Player("Dushmantha Chameera", "DC", "BOWLER", "Sri Lanka", 0.75),
                new Player("Donovan Ferreira", "DC", "BATSMAN", "South Africa", 0.75),
                new Player("Ajay Mandal", "DC", "ALL_ROUNDER", "India", 0.3),
                new Player("Kagiso Rabada", "GT", "BOWLER", "South Africa", 10.75),
                new Player("Jos Buttler", "GT", "BATSMAN", "England", 15.75),
                new Player("Mohammad Siraj", "GT", "BATSMAN", "India", 12.25),
                new Player("Prasidh Krishna", "GT", "BOWLER", "India", 9.5),
                new Player("Nishant Sindhu", "GT", "ALL_ROUNDER", "India", 0.3),
                new Player("Mahipal Lomror", "GT", "ALL_ROUNDER", "India", 1.7),
                new Player("Kumar Kushagra", "GT", "WICKETKEEPER", "India", 0.65),
                new Player("Anuj Rawat", "GT", "WICKETKEEPER", "India", 0.3),
                new Player("Manav Suthar", "GT", "BOWLER", "India", 0.3),
                new Player("Washington Sundar", "GT", "ALL_ROUNDER", "India", 3.2),
                new Player("Gerald Coetzee", "GT", "BOWLER", "South Africa", 2.4),
                new Player("Arshad Khan", "GT", "ALL_ROUNDER", "India", 1.3),
                new Player("Gurnoor Brar", "GT", "BOWLER", "India", 1.3),
                new Player("Nicholas Pooran", "LSG", "WICKETKEEPER", "West Indies", 21.0),
                new Player("Ravi Bishnoi", "LSG", "BOWLER", "India", 11.0),
                new Player("Mayank Yadav", "LSG", "BOWLER", "India", 11.0),
                new Player("Rohit Sharma", "MI", "BATSMAN", "India", 16.3),
                new Player("Tilak Varma", "MI", "BATSMAN", "India", 8.0),
                new Player("Heinrich Klaasen", "SRH", "BATSMAN", "South Africa", 23.0),
                new Player("Pat Cummins", "SRH", "BOWLER", "Australia", 18.0),
        };

        return players;
    }
}
