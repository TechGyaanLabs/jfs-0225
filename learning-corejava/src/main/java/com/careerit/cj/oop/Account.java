package com.careerit.cj.oop;

public class Account {

    private String accNum;
    private String name;
    private double balance;

    public Account() {

    }
    public Account(String accNum, String name, double balance) {
        this.accNum = accNum;
        this.name = name;
        this.balance = balance;
    }

    public void showDetails() {
        System.out.println("Account Number: " + accNum);
        System.out.println("Name: " + name);
        System.out.println("Balance: " + balance);
    }

    public void withdraw(double amt) {
        if (amt > balance) {
            System.out.println("Insufficient Balance");
        } else {
            balance -= amt;
            System.out.println("Amount \"" + amt + "\" has been withdrawn successfully, current balance is \"" + balance + "\"");
        }
    }

    public void deposit(double amt) {
        balance += amt;
        System.out.println("Amount \"" + amt + "\" has been deposited successfully, current balance is \"" + balance + "\"");
    }
}
