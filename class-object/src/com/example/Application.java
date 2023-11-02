package com.example;

import com.example.model.*;

public class Application {
    public static void main(String[] args) {

        Account account1=new Account("12345");
        Account account2=new Account("67890");

        account1.deposit(1000.00);
        account2.deposit(2000.00);

        System.out.println(account1.balance);
        System.out.println(account2.balance);

        account1.withdraw(1000.00);

        System.out.println(account1.balance);

    }
}
