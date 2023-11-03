package com.example;

import com.example.bill.Billing;
import com.example.bill.OnlineBilling;
import com.example.pm.DatabasePriceMatrix;
import com.example.pm.ExcelPriceMatrix;
import com.example.pm.PriceMatrix;

public class Application {
    public static void main(String[] args) {

        //--------------------------------
        // Init phase
        //--------------------------------

        // based configuration parameters,
        // create components and assemble them

        PriceMatrix excelPriceMatrix=new ExcelPriceMatrix();
        PriceMatrix databasePriceMatrix=new DatabasePriceMatrix();

        Billing onlineBillingWithExcelPM=new OnlineBilling(excelPriceMatrix);
        Billing onlineBillingWithDatabasePM=new OnlineBilling(databasePriceMatrix);

        //--------------------------------
        // Use phase
        //--------------------------------

        String[] cart1={"123","456","789"};
        double totalPrice=onlineBillingWithExcelPM.getTotalPrice(cart1);
        System.out.println(totalPrice);

        //--------------------------------
        // Destroy/ Clean phase
        //--------------------------------

    }
}
