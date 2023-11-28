package com.example.health;

import java.net.Socket;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MySQLHealthIndicator implements HealthIndicator{

    @Override
    public Health health() {
    try (Socket socket = 
        new Socket("localhost", 3306)) {
    } catch (Exception e) {
      return Health.down()
        .withDetail("error", e.getMessage())
        .build();
    }
    return Health.up().build();
    }

    
    
}
