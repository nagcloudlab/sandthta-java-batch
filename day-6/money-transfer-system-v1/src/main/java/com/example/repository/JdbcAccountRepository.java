package com.example.repository;

import com.example.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JdbcAccountRepository implements AccountRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger("mts");

    public JdbcAccountRepository(){
        LOGGER.info("JdbcAccountRepository component instance created");
    }

    @Override
    public Account loadAccount(String accountNumber) {
        LOGGER.info("loading account - {}", accountNumber);
        // TODO
        return new Account(accountNumber,1000.00);
    }

    @Override
    public Account updateAccount(Account account) {
        LOGGER.info("updating account - {}", account.getNumber());
        // TODO
        return account;
    }
}
