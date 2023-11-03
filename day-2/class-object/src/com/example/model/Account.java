// package declaration
package com.example.model;

// import statements
import java.lang.*;

/**
 * @author Nag
 */

// public Type
public class Account {
    // variables
    // a. class variables
    public static String bankName;
    // b. instance variables
    private String accountNumber;
    private double balance;
    // constructors
    public Account(String an){
        if(!accountNumber.isEmpty()){
            this.accountNumber=an;
            this.balance=0.00;
        }else{
            System.out.println("Invalid Account Number");
        }
    }
    // methods
    public String getAccountNumber() {
        return accountNumber;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        if(balance>0 && balance<=10000.00) {
            this.balance = balance;
        }else{
            System.out.println("Invalid Amount");
        }
    }
    public void deposit(double amount) {
        this.balance += amount;
    }
    public void withdraw(double amount) {
        this.balance -= amount;
    }
}
