package com.example.bill;

import com.example.pm.PriceMatrix;

/**
 *   billing-object  'has' price-matrix-object
 *
 *
 */

public class OnlineBilling implements Billing{

    private PriceMatrix priceMatrix;

    public OnlineBilling(PriceMatrix priceMatrix){
        this.priceMatrix = priceMatrix;
    }

    public double getTotalPrice(String[] cart) {
        double totalPrice = 0;
        for(String itemCode : cart){
            totalPrice+=priceMatrix.getPrice(itemCode);
        }
        return totalPrice;
    }
}
