package com.example.repository;

import com.example.model.Account;

/**
 * author : Team-1
 */

public class MySqlAccountRepository implements AccountRepository {

    public MySqlAccountRepository(){
        System.out.println("MySqlAccountRepository component instance created");
    }

    public Account loadAccount(String accountNUmber) {
        // SELECT ..
        return new Account(accountNUmber, 1000.00);
    }
    public Account updateAccount(Account account){
        // UPDATE ..
        return account;
    }

}
