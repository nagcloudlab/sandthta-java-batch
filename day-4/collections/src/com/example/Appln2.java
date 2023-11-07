package com.example;

import com.example.model.Account;
import com.example.model.Customer;

import java.util.Map;
import java.util.TreeMap;

public class Appln2 {
    public static void main(String[] args) {

        Customer customer1 = new Customer("111", "Riya");
        Customer customer2 = new Customer("111", "Riya");

        Account account1 = new Account("123", 1000.00);
        Account account2 = new Account("456", 1000.00);

        Map<Customer, Account> map = new TreeMap<>();
        map.put(customer1, account1);
        map.put(customer2, account2);

        System.out.println(map.size());
        System.out.println(map.get(customer1));


    }
}
