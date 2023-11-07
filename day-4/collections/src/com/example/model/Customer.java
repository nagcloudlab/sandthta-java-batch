package com.example.model;

public class Customer implements Comparable<Customer> {

    private String customerId;
    private String name;

    @Override
    public int compareTo(Customer o) {
       return customerId.compareTo(o.customerId);
    }

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }
}
