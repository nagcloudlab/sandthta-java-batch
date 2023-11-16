package com.example.exeption;

public class AccountBalanceException extends RuntimeException {
    public AccountBalanceException(String message) {
        super(message);
    }
}
