package com.example.model;

public class Account extends Object implements Comparable<Account> {

    private String number;
    private double balance;

    @Override
    public int compareTo(Account o) {
        return this.number.compareTo(o.number);
    }
    @Override
    public int hashCode() {
        // hashing alogithm
        // if 2 accounts has same number, return same-hashcode
        return this.number.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        Account other=(Account)obj;
        return this.number.equals(other.number);
    }

    public Account(String number, double balance) {
        this.number = number;
        this.balance = balance;
    }

    public Account(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "number='" + number + '\'' +
                ", balance=" + balance +
                '}';
    }
}
