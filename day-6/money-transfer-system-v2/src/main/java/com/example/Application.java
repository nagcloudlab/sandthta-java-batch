package com.example;

import com.example.config.MoneyTransferSystemConfiguration;
import com.example.repository.AccountRepository;
import com.example.repository.JdbcAccountRepository;
import com.example.service.TransferService;
import com.example.service.UPITransferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger("mts");

    public static void main(String[] args) {

        //--------------------------------
        // init / boot phase
        // -> prepare business-components based on configuration
        //--------------------------------

        ConfigurableApplicationContext applicationContext=
                new AnnotationConfigApplicationContext(MoneyTransferSystemConfiguration.class);


        LOGGER.info("-".repeat(50));
        //--------------------------------
        // use phase
        // -> invoke use cases based on request
        //--------------------------------
        TransferService upiTransferService=applicationContext.getBean("upiTransferService",TransferService.class);
        upiTransferService.transfer(100.00,"1","2");

        //--------------------------------
        // close / clean / destroy phase
        //--------------------------------
        LOGGER.info("-".repeat(50));
        // ..
        applicationContext.close();

    }
}
