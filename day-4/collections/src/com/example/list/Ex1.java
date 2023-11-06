package com.example.list;


import com.example.model.Account;

import java.util.*;

public class Ex1 {
    public static void main(String[] args) {

//
//        List<String> employeeNames = new Vector<>();
//        employeeNames=new ArrayList<>();
//        employeeNames=new LinkedList<>();
//
//        employeeNames.add("sarath");
//        employeeNames.add("bavesh");
//        employeeNames.add("colin");
//        employeeNames.add("devanathan");

        //----------------------------------------------------------------
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("123", 100.00));
        accounts.add(new Account("124", 200.00));
        accounts.add(new Account("126", 300.00));
        accounts.add(new Account("121", 600.00));
        accounts.add(new Account("127", 100.00));
        accounts.add(new Account("129", 200.00));
        accounts.add(new Account("129", 200.00));

        //----------------------------------------------------------------
        // Looping / iteration
        //----------------------------------------------------------------
        // way-1:

//        Iterator<Account> it=accounts.iterator();
//        while (it.hasNext()){
//            Account account=it.next();
//            System.out.println(account);
//        }

        // way-2 : for-each loop
        for(Account account:accounts){
            System.out.println(account);
        }

        //----------------------------------------------------------------

        

    }
}
