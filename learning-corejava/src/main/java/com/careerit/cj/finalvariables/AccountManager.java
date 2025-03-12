package com.careerit.cj.finalvariables;

class Account{
    final  String BANK_NAME = "ICICI";
    String accountNumber;
    String name;
    double balance;

    Account(String accountNumber, String name, double balance){
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }
}
public class AccountManager {

    public static void main(final String[] args) {
        args[0] = "123456";

        Account account = new Account("123456", "ABC", 10000.00);
    }

    public static void display(final Account account){
       account.name = "XYZ";
    }
}


