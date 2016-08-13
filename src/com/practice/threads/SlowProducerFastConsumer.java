package com.practice.threads;

import java.util.ArrayList;

/**
 * Created by SKapadia on 7/31/2016.
 */
public class SlowProducerFastConsumer {

    public class Producer implements Runnable {

        private ArrayList<Integer> arrayList;

        public Producer(ArrayList<Integer> arrayList) {
            this.arrayList = arrayList;
        }

        @Override
        public void run() {

            int count = 0;
            while(true) {
                System.out.println("Adding item: " + count);
                arrayList.add(count);
                count++;
                try {
                    Thread.sleep(1000);
                } catch(Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public class Consumer implements Runnable {

        private ArrayList<Integer> arrayList;

        public Consumer(ArrayList<Integer> arrayList) {
            this.arrayList = arrayList;
        }

        @Override
        public void run() {

            while(true) {
                if(!arrayList.isEmpty()) {
                    System.out.println("Removing item: " + arrayList.remove(0));
                }
                try {
                    Thread.sleep(500);
                } catch(Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ArrayList<Integer> arrayList = new ArrayList<>();
        SlowProducerFastConsumer object = new SlowProducerFastConsumer();

        Thread p = new Thread(object.new Producer(arrayList));
        Thread c = new Thread(object.new Consumer(arrayList));
        p.setDaemon(true);
        c.setDaemon(true);
        p.start();
        c.start();

        p.join();
        c.join();
    }
}
