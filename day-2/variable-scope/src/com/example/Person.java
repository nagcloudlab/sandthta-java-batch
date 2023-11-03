package com.example;

public class Person {
    private static int helloCount; // class/static variables
//    private int helloCount; // instance/object variables
    public String name;
    public void sayHello(){
        //int helloCount=0; // local variables
        helloCount++;
        System.out.println(name+" => hello ("+helloCount+")");
    }

}
