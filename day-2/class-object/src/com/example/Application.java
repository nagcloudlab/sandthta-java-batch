package com.example;

import com.example.model.*;

public class Application {
    public static void main(String[] args) {


        //--------------------------------
        // Module-1  : team-1
        // --------------------------------

        Account account = new Account("12345");

        //--------------------------------
        // Module-2 : team-2
        // --------------------------------
        System.out.println(account.getAccountNumber());
        account.setBalance(100.00);
        System.out.println(account.getBalance());

        account.deposit(100.00);
        System.out.println(account.getBalance());
        //--------------------------------


    }
}
