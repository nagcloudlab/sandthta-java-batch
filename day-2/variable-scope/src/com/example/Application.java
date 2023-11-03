package com.example;

public class Application {
    public static void main(String[] args) {

        Person p1=new Person();
        p1.name="P1";

        Person p2=new Person();
        p2.name="P2";


        p1.sayHello();
        p2.sayHello();
        p2.sayHello();

        System.out.println("hello");

    }
}
