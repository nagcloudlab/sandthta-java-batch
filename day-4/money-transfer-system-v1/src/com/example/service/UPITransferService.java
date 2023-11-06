package com.example.service;

import com.example.exception.AccountBalanceException;
import com.example.exception.AccountNotFoundException;
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
        if(sourceAccount == null){
            AccountNotFoundException anfe=new AccountNotFoundException("source account not found");
            anfe.setNumber(sourceAccNumber);
            throw anfe;
        }
        // Load destination account
        Account destinationAccount = accountRepository.loadAccount(destinationAccNumber);
        if(destinationAccount == null){
            AccountNotFoundException anfe=new AccountNotFoundException("destination account not found");
            anfe.setNumber(destinationAccNumber);
            throw anfe;
        }
        // source balance >= amount
        if(sourceAccount.getBalance()<amount){
            AccountBalanceException abe=new AccountBalanceException("source balance not enough");
            abe.setBalance(sourceAccount.getBalance());
            throw abe;
        }
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
