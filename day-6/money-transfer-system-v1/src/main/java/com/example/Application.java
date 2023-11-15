package com.example;

import com.example.repository.AccountRepository;
import com.example.repository.JdbcAccountRepository;
import com.example.service.TransferService;
import com.example.service.UPITransferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger("mts");

    public static void main(String[] args) {

        //--------------------------------
        // init / boot phase
        // -> prepare business-components based on configuration
        //--------------------------------

        // by configuration
        // upiTransferService + jdbcAccountRepository

        AccountRepository jdbcAccountRepository=new JdbcAccountRepository();
        TransferService upiTransferService=new UPITransferService(jdbcAccountRepository);

        LOGGER.info("-".repeat(50));
        //--------------------------------
        // use phase
        // -> invoke use cases based on request
        //--------------------------------

        upiTransferService.transfer(100.00,"123","456");
        LOGGER.info("-".repeat(25));
        upiTransferService.transfer(100.00,"456","123");

        //--------------------------------
        // close / clean / destroy phase
        //--------------------------------
        LOGGER.info("-".repeat(50));
        // ..

    }
}
