package com.example;


class Counter {
    private long count = 0;

    public synchronized void  incrementCount() {
        count += 1; // read --> increment count by 1 --> write
    }
    public long getCount() {
        return count;
    }
}


public class Ex3 {
    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.incrementCount();
            }
        };

        Thread[] threads = new Thread[1000];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }

        //----------------------------------------------------
        Thread.sleep(5000);
        System.out.println(counter.getCount()); // 1000 * 1000 = 1000000


    }
}
