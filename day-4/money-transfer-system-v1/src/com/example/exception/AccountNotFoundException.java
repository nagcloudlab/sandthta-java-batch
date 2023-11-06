package com.example.exception;


public class AccountNotFoundException extends RuntimeException {
    private String number;
    public AccountNotFoundException(String message){
        super(message);
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}
