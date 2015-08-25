package com.practice.threads;

public class RaceCondition implements Runnable {

    public int count;

    RaceCondition() {
        count = 0;
    }

    @Override
    public void run() {

        synchronized (this) {
            for (int i = 0; i < 100000; i++) {
                count++;
            }
        }
    }

    public void printCount() {
        System.out.println(count);
    }

    public static void main(String[] args) throws InterruptedException {

        Runnable r = new RaceCondition();
        Thread[] t = new Thread[10];

        for (int i = 0; i < 10; i++) {
            t[i] = new Thread(r);
            t[i].start();
        }

        for (int i = 0; i < 10; i++) {
            //t[i].join();
        }
        ((RaceCondition) r).printCount();
    }
}
