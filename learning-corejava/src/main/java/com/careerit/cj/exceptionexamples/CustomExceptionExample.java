package com.careerit.cj.exceptionexamples;


class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }

}

class InvalidAccountException extends RuntimeException {
    public InvalidAccountException(String message) {
        super(message);
    }
}
class Account{
    private String accNumber;
    private String name;
    private double balance;
    public Account(String accNumber, String name, double balance) {
        if(accNumber == null || accNumber.length() != 10){
            throw new InvalidAccountException("Invalid account number: " + accNumber);
        }
        this.accNumber = accNumber;
        this.name = name;
        this.balance = balance;
    }
    public void withdraw(double amount) throws InsufficientFundsException {
        if(amount > balance){
            throw new InsufficientFundsException("Insufficient funds in account: " + accNumber);
        }
        balance -= amount;
    }
    public void deposit(double amount) {
        balance += amount;
    }

}

public class CustomExceptionExample {
}
