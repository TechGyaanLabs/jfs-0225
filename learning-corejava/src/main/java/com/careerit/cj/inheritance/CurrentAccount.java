package com.careerit.cj.inheritance;

public class CurrentAccount extends Account {

    private double overDraftAmount;

    public CurrentAccount(String accountNumber, String accountHolder, double balance, double overDraftAmount) {
        super(accountNumber, accountHolder, balance);
        this.overDraftAmount = overDraftAmount;
    }

    @Override
    public void withdraw(double amount){
        if(amount > balance + overDraftAmount){
            System.out.println("Insufficient funds");
        }else{
            balance = balance - amount;
            System.out.println("Amount " + " " + amount + " " +
                    "withdrawn from account" + " " + MastUtil.accNumber(accNumber) + " and balance is " + balance);
        }
    }
}
