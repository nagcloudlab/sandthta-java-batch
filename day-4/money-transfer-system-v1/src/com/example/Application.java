package com.example;

import com.example.exception.AccountBalanceException;
import com.example.exception.AccountNotFoundException;
import com.example.factory.AccountRepositoryFactory;
import com.example.repository.AccountRepository;
import com.example.service.TransferService;
import com.example.service.UPITransferService;

public class Application {
    public static void main(String[] args) {

        //--------------------------------
        // Init / boot phase
        //--------------------------------

        AccountRepository mysqlAccountRepository= AccountRepositoryFactory.getAccountRepository("mysql");
        TransferService transferService = new UPITransferService(mysqlAccountRepository); // DI

//        AccountRepository oracleAccountRepository= AccountRepositoryFactory.getAccountRepository("oracle");
//        TransferService txrService=new UPITransferService(oracleAccountRepository);

        //--------------------------------
        // Use phase
        //--------------------------------
        try {
            System.out.println("-".repeat(100));
            transferService.transfer(300.00, "123", "456");
            System.out.println();
            transferService.transfer(300.00, "456", "123");
            System.out.println("-".repeat(100));
        }catch (AccountNotFoundException | AccountBalanceException e){
            e.printStackTrace();
        }
        //--------------------------------
        // clean / Destroy phase
        //--------------------------------

    }
}
