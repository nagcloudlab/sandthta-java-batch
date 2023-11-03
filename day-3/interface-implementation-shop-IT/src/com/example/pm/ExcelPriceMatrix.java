package com.example.pm;

public class ExcelPriceMatrix implements PriceMatrix {
    public double getPrice(String itemCode) {
        // read the latest-price from excel
        return 1000.00;
    }
}
