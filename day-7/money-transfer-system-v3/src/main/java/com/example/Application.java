package com.example;

import com.example.service.TransferService;
import com.spring.config.MyAutoConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//@Import(MyAutoConfiguration.class)
@EnableAutoConfiguration
@ComponentScan
public class Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {

        //--------------------------------
        // init / boot phase
        // -> prepare business-components based on configuration
        //--------------------------------

        ConfigurableApplicationContext applicationContext =
                SpringApplication.run(Application.class);


        LOGGER.info("-".repeat(50));
        //--------------------------------
        // use phase
        // -> invoke use cases based on request
        //--------------------------------

        //TransferService upiTransferService = applicationContext.getBean(TransferService.class);
        //upiTransferService.transfer(100.00, "1", "2");

        String bean1=applicationContext.getBean("bean1",String.class);
        System.out.println(bean1);

        //--------------------------------
        // close / clean / destroy phase
        //--------------------------------
        LOGGER.info("-".repeat(50));
        // ..
        applicationContext.close();


    }

}
