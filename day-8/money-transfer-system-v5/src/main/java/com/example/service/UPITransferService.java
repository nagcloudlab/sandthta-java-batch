package com.example.service;

import com.example.entity.Account;
import com.example.entity.Transaction;
import com.example.entity.TxnType;
import com.example.exception.AccountBalanceException;
import com.example.exception.AccountNotFoundException;
import com.example.repository.AccountRepository;
import com.example.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

//@Component
@Service
public class UPITransferService implements TransferService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    @Value("${mybank.upi.transfer.limit: 1000.00}")
    private double transferLimit;

    @Override
    @Transactional
    public TransferStatus transfer(double amount, String sourceAccNumber, String destAccNumber) {

        System.out.println("-".repeat(50));
        System.out.println(transferLimit);
        System.out.println("-".repeat(50));

        // load source & destination accounts
        Account sourceAccount = accountRepository.findById(sourceAccNumber).orElseThrow(
                () -> new AccountNotFoundException("source account not found: " + sourceAccNumber));
        Account destinationAccount = accountRepository.findById(destAccNumber).orElseThrow(
                () -> new AccountNotFoundException("destination account not found"));

        // debit & credit
        if (sourceAccount.getBalance() < amount) {
            throw new AccountBalanceException("source account balance not greater than " + amount);
        }
        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        destinationAccount.setBalance(destinationAccount.getBalance() + amount);

        // update source & destination accounts
        accountRepository.save(sourceAccount); // step-1
        accountRepository.save(destinationAccount); // step-2

        // insert transaction records
        Transaction debitTxn = new Transaction();
        debitTxn.setType(TxnType.DEBIT);
        debitTxn.setAmount(amount);
        debitTxn.setDateTime(LocalDateTime.now());
        debitTxn.setAccount(sourceAccount);

        Transaction creditTxn = new Transaction();
        creditTxn.setType(TxnType.CREDIT);
        creditTxn.setAmount(amount);
        creditTxn.setDateTime(LocalDateTime.now());
        creditTxn.setAccount(destinationAccount);

        debitTxn = transactionRepository.save(debitTxn); // step-3
        transactionRepository.save(creditTxn); // // step-4
        TransferStatus transferStatus = new TransferStatus(debitTxn.getId(), "Transfer successful");
        return transferStatus;

    }
}
