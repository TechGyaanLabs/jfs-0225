package com.careerit.cj.stringexample;

class Account {
    private String accNumber;
    private String name;
    private double balance;

    public Account(String accNumber, String name, double balance) {
        this.accNumber = accNumber;
        this.name = name;
        this.balance = balance;
    }

    public void showBalance() {
        System.out.println("Account Number: " + StringUtilExample.maskAccountNumber(accNumber) + " Name: " + name + " Balance: " + balance);
    }
}

public class StringUtilExample {

    public static String maskAccountNumber(String accountNumber) {
        if (accountNumber != null && accountNumber.length() >= 4) {
            return "*******".concat(accountNumber.substring(accountNumber.length() - 4));
        }
        return accountNumber;

    }

    public static void main(String[] args) {
        Account[] accounts = getAccounts();
        for (Account account : accounts) {
            account.showBalance();
        }
        System.out.println(isPalindrome( "abba" ));
        System.out.println(isPalindrome("abcdefcba"));
    }

    private static Account[] getAccounts() {

        Account account1 = new Account("SB1234567890", "Krishna", 500000);
        Account account2 = new Account("SB1234567891", "John Doe", 300000);
        Account account3 = new Account("SB1234567892", "Tanvi A", 300000);
        Account account4 = new Account("SB1234567893", "Manasa A", 300000);
        Account account5 = new Account("SB1234567894", "Charan K", 400000);
        return new Account[]{account1, account2, account3, account4, account5};



    }


    public static boolean isPalindrome(String str) {

        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }


}
