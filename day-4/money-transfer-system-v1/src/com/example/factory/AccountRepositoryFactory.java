package com.example.factory;

import com.example.repository.AccountRepository;
import com.example.repository.MySqlAccountRepository;
import com.example.repository.OracleAccountRepository;

// Factory class
public class AccountRepositoryFactory {
    // Factory Method
    public static AccountRepository getAccountRepository(String databaseName) {
        if (databaseName.equals("mysql")) {
            MySqlAccountRepository mySqlAccountRepository = new MySqlAccountRepository();
            return mySqlAccountRepository;
        } else if (databaseName.equals("oracle")) {
            return new OracleAccountRepository();
        } else {
            return null;
        }
    }
}
