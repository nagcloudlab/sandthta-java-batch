// package declaration
package com.example.model;

// import statements
import java.lang.*;

// public Type
public class Account {
    // variables
    // a. class variables
    public static String bankName;
    // b. instance variables
    public String accountNumber;
    public double balance;
    // constructors
    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public Account(String accountNumber){
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }
    // methods
    public void deposit(double amount) {
        this.balance += amount;
    }
    public void withdraw(double amount) {
        this.balance -= amount;
    }
}
