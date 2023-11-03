package com.example.pm;

public class DatabasePriceMatrix implements PriceMatrix{
    public double getPrice(String itemCode) {
        // read the price from the database
        return 200.00;
    }
}
