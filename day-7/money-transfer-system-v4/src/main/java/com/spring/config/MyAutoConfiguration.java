package com.spring.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ConditionalOnWebApplication
//@ConditionalOnProperty("com.example.location")
public class MyAutoConfiguration {

    @Bean
    public String bean1() {
        return "BEAN-1";
    }

}
