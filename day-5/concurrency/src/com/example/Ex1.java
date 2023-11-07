package com.example;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName());

        Thread thread1=new Thread(()->{
            io();
        },"foo");
        Thread thread2=new Thread(()->{
            computation();
        },"bar");


        thread1.start(); //
        thread2.start(); //

        System.out.println("main cont.. with other work..");


    }

    private static void computation() {
        System.out.println(Thread.currentThread().getName() + " started computation");
        long v=0;
        for (int i=0; i<100000; i++) {
            v++;
        }
        System.out.println(v);
        System.out.println(Thread.currentThread().getName() + " finished IO");
    }

    private static void io() {
        System.out.println(Thread.currentThread().getName() + " started IO");
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your name?");
        String name = scanner.nextLine();
        System.out.println("hello " + name);
        scanner.close();
        System.out.println(Thread.currentThread().getName() + " finished IO");
    }
}
