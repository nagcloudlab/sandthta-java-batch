package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Account;
import com.example.exception.NotEnoughBalanceException;
import com.example.exception.NotFoundException;
import com.example.repository.AccountRepository;

@Service
public class UPITransferService implements TransferService{

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void transfer(double amount, String source, String destination) {
        
        Account sourceAccount=accountRepository.findById(source)
        .orElseThrow(()->new NotFoundException("source account not found"+source));
        Account destinationAccount=accountRepository.findById(destination)
        .orElseThrow(()->new NotFoundException("destination account not found"+source));

        if(sourceAccount.getBalance()<amount)
        throw new NotEnoughBalanceException("not enough balance");
        
        sourceAccount.setBalance(sourceAccount.getBalance()-amount);
        destinationAccount.setBalance(destinationAccount.getBalance()+amount);

        accountRepository.save(sourceAccount);
        accountRepository.save(destinationAccount);

    }
    
}
