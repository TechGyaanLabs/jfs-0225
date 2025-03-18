package com.careerit.cj.inheritance;

public class Account {

    protected String accNumber;
    protected String name;
    protected double balance;

    public Account(String accNumber, String name, double balance) {
        this.accNumber = accNumber;
        this.name = name;
        this.balance = balance;
    }

    public void showDetails() {
        System.out.println("Account Number: " + MastUtil.accNumber(accNumber));
        System.out.println("Account Name: " + name);
        System.out.println("Account Balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient Balance");
        } else {
            balance = balance - amount;
            System.out.println("Amount " + " " + amount + " " +
                    "withdrawn from account" + " " + MastUtil.accNumber(accNumber) + " and balance is " + balance);
        }
    }

    public void deposit(double amount){
        balance = balance + amount;
        System.out.println("Amount " + " " + amount + " " +
                "deposited into account" + " " + MastUtil.accNumber(accNumber) + " and balance is " + balance);
    }

}
