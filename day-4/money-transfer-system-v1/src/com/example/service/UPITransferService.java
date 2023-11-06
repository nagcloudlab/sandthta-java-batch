package com.example.service;

import com.example.factory.AccountRepositoryFactory;
import com.example.model.Account;
import com.example.repository.AccountRepository;
//import com.example.repository.MySqlAccountRepository;

public class UPITransferService implements TransferService {

    private AccountRepository accountRepository;

    // dependency injection will happen via constructor
    public UPITransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        System.out.println("UPITransferService component instance created");
    }

    @Override
    public void transfer(double amount, String sourceAccNumber, String destinationAccNumber) {
        System.out.println("transfer initiated..");
        //MySqlAccountRepository accountRepository = new MySqlAccountRepository(); // Don't create
        //AccountRepository accountRepository = AccountRepositoryFactory.getAccountRepository("mysql"); // Don't find
        // Load source account
        Account sourceAccount = accountRepository.loadAccount(sourceAccNumber);
        // Load destination account
        Account destinationAccount = accountRepository.loadAccount(destinationAccNumber);
        // debit
        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        // credit
        destinationAccount.setBalance(sourceAccount.getBalance() + amount);
        System.out.println("debit & credit");
        // Update source account
        accountRepository.updateAccount(sourceAccount);
        // Update destination account
        accountRepository.updateAccount(destinationAccount);
        System.out.println("transfer successfully completed");
    }

}
