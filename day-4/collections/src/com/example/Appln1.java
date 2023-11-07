package com.example;

import com.example.model.Account;

import java.util.*;

public class Appln1 {
    public static void main(String[] args) {

//        List<Account> accounts = new ArrayList<>();
//        List<Account> accounts = new LinkedList<>();
//        Set<Account> accounts = new TreeSet<>();
//        Set<Account> accounts = new HashSet<>();
        Set<Account> accounts = new LinkedHashSet<>();
        accounts.add(new Account("123", 100.00));
        accounts.add(new Account("125", 200.00));
        accounts.add(new Account("124", 400.00));
        accounts.add(new Account("121", 200.00));

        Account a1 = new Account("127", 300.00);
        Account a2 = new Account("127", 300.00);

        System.out.println(a1.hashCode());
        System.out.println(a2.hashCode());
        System.out.println(a1.equals(a2));

        boolean a = accounts.add(a1);
        System.out.println(a);
        boolean b = accounts.add(a2);
        System.out.println(b);

        //Collections.sort(accounts);

        display(accounts);

    }

    private static void display(Collection<Account> accounts) {
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}
