package com.example.service;

import com.example.model.Account;
import com.example.repository.AccountRepository;
import com.example.repository.JdbcAccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UPITransferService implements TransferService {

    private static final Logger LOGGER = LoggerFactory.getLogger("mts");

    private AccountRepository accountRepository;

    public UPITransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        LOGGER.info("UPITransferService component instance created");
    }

    @Override
    public void transfer(double amount, String sourceAccNumber, String destAccNumber) {
        LOGGER.info("transfer initiated");
        //JdbcAccountRepository accountRepository = new JdbcAccountRepository();
        // load source & destination account details
        Account sourceAccount = accountRepository.loadAccount(sourceAccNumber);
        Account destAccount = accountRepository.loadAccount(destAccNumber);
        // debit & credit
        LOGGER.info("debit & credit");
        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        destAccount.setBalance(destAccount.getBalance() + amount);
        // update source & destination accounts
        accountRepository.updateAccount(sourceAccount);
        accountRepository.updateAccount(destAccount);
        LOGGER.info("transfer successful");
    }

}
