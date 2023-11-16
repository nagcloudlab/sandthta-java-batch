package com.example.service;

import com.example.exeption.AccountBalanceException;
import com.example.exeption.AccountNotFoundException;
import com.example.model.Account;
import com.example.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UPITransferService implements TransferService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UPITransferService.class);

    @Autowired
    @Qualifier("jpaAccountRepository")
    private AccountRepository accountRepository;

    @Override
    @Transactional
    public void transfer(double amount, String sourceAccNumber, String destAccNumber) {
        LOGGER.info("transfer initiated");
        //JdbcAccountRepository accountRepository = new JdbcAccountRepository();
        // load source & destination account details
        Account sourceAccount = accountRepository.loadAccount(sourceAccNumber);
        Account destAccount = accountRepository.loadAccount(destAccNumber);
        if(sourceAccount==null)
            throw new AccountNotFoundException("Source account not found, accountNumber: " + sourceAccNumber);
        if(destAccount==null)
            throw new AccountNotFoundException("Destination account not found, accountNumber:"+destAccNumber);
        LOGGER.info(sourceAccount.toString());
        LOGGER.info(destAccount.toString());
        if(sourceAccount.getBalance()<amount){
            throw new AccountBalanceException("Source account balance not greater than " + amount);
        }
        // debit & credit
        LOGGER.info("debit & credit");
        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        destAccount.setBalance(destAccount.getBalance() + amount);
        // update source & destination accounts
        sourceAccount = accountRepository.updateAccount(sourceAccount);
        destAccount = accountRepository.updateAccount(destAccount);
        LOGGER.info(sourceAccount.toString());
        LOGGER.info(destAccount.toString());
        LOGGER.info("transfer successful");
    }

}
