package com.example;

import com.example.model.Account;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Ex1 {
    public static void main(String[] args) {

        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("123", 100.00));
        accounts.add(new Account("125", 200.00));
        accounts.add(new Account("124", 400.00));
        accounts.add(new Account("121", 300.00));
        accounts.add(new Account("127", 600.00));
        accounts.add(new Account("127", 500.00));


        //Collections.sort(accounts, (o1, o2) -> Double.compare(o1.getBalance(), o2.getBalance()));
        //Collections.sort(accounts, (o1, o2) -> Double.compare(o2.getBalance(), o1.getBalance()));
        accounts.sort((o1, o2)->Double.compare(o1.getBalance(), o2.getBalance())); // FP

        display(accounts);

    }

    private static void display(List<Account> accounts) {
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}
