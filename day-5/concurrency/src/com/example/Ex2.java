package com.example;

public class Ex2 {
    public static void main(String[] args) throws InterruptedException {

        Runnable task = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " -> " + i);
                if(i==20 && Thread.currentThread().getName().equals("foo")){
                    try {
                        Thread.sleep(10*1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        Thread thread1 = new Thread(task, "foo");
        Thread thread2 = new Thread(task, "bar");
        Thread thread3 = new Thread(task, "baz"); // NEW

//        System.out.println(thread1.getState());
//        thread1.start();
//        System.out.println(thread1.getState());
//        Thread.sleep(5000);
//        System.out.println(thread1.getState());
//        thread1.start();

        thread1.start();
        thread2.start();
        thread3.start();


    }
}
