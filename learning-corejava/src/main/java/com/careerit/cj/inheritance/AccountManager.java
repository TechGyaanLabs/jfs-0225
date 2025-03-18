package com.careerit.cj.inheritance;

import java.util.ArrayList;
import java.util.List;

public class AccountManager {

    public static void main(String[] args) {
        List<Account> accounts = getAccountsList();
        // Show only current account details

        for(Account acc:accounts){
            if(acc instanceof CurrentAccount){
                acc.showDetails();
            }
        }


    }

    private static List<Account> getAccountsList() {
        Account acc3 = new CurrentAccount("CB301000900102", "Infinix", 100000, 10000);
        Account acc1 = new Savings("SB301000900101", "Krish", 50000, 5000);
        Account acc2 = new Savings("SB301000900191", "Rajesh", 100000, 5000);
        Account acc4 = new CurrentAccount("CB301000900192", "TGS", 50000, 10000);
        Account acc5 = new CurrentAccount("CB301000900193", "KGF", 50000, 10000);
        List<Account> accounts = new ArrayList<>();
        accounts.add(acc1);
        accounts.add(acc2);
        accounts.add(acc3);
        accounts.add(acc4);
        accounts.add(acc5);
        return accounts;
    }
}
