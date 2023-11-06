package com.example.exception;

public class AccountBalanceException extends RuntimeException {
    private double balance;
    public AccountBalanceException(String message){
        super(message);
    }
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
