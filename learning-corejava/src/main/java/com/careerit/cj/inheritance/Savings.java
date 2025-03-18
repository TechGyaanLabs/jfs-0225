package com.careerit.cj.inheritance;

class Savings extends Account {

    private double minBalance;

    public Savings(String accountNumber, String name, double balance, double minBalance) {
        super(accountNumber, name, balance);
        this.minBalance = minBalance;
    }

    @Override
    public void withdraw(double amount){
            if(amount > balance - minBalance){
                System.out.println("Insufficient funds");
            }else{
                balance = balance - amount;
                System.out.println("Amount " + " " + amount + " " +
                        "withdrawn from account" + " " + MastUtil.accNumber(accNumber) + " and balance is " + balance);
            }
    }
}
