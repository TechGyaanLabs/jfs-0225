package com.careerit.cj.staticexample;


class Account{
    String accNumber;
    String name;
    double balance;
    static int count = 0;

    Account(String accNumber, String name, double balance){
        this.accNumber = accNumber;
        this.name = name;
        this.balance = balance;
        count++;
    }

    void showDetails(){
        System.out.println("Account Number: "+accNumber);
        System.out.println("Account Name: "+name);
        System.out.println("Account Balance: "+balance);
        System.out.println();
    }
}
public class StaticVariableExample {

    public static void main(String[] args) {

        System.out.println(Account.count);
        Account a1 = new Account("1234567890", "John", 100000.00);
        Account a2 = new Account("2343565667", "Manoj", 200000.00);
        a1.showDetails();
        a2.showDetails();
        System.out.println(Account.count);

    }
}
