package com.careerit.cj.inheritance;

public class AccountManager {

    public static void main(String[] args) {

        Account acc1 = new Account("SB301000900101", "Krish", 50000);
        Account acc2 = new Account("SB301000900191", "Rajesh", 100000);

        System.out.println("Account Details:");

        acc1.showDetails();
        System.out.println("-".repeat(50));
        acc2.showDetails();
        System.out.println("-".repeat(50));

        acc1.deposit(10000);
        acc1.withdraw(5000);

        acc2.deposit(10000);

        acc1.showDetails();
        System.out.println("-".repeat(50));
        acc2.showDetails();
    }
}
