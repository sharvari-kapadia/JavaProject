package com.practice.threads;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/*
 * Create producer and consumer threads such that the producer will produce N items
 * and consumer will consume those N items. When N items are over, the task is done.
 */
public class ProducerConsumer {

    private final int MAX_WORK_ITEMS = 50;
    public final int MAX_WORK_ITEMS_IN_QUEUE = 10;
    public Queue<Work> queue;
    public Lock lock;
    public Condition queueEmpty;
    public Condition queueFull;

    ProducerConsumer() {
        queue = new LinkedList<Work>();
        lock = new ReentrantLock();
        queueEmpty = lock.newCondition();
        queueFull = lock.newCondition();
    }

    // Producer thread
    private class ProducerBC implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < MAX_WORK_ITEMS; i++) {

//				if (i % 3 == 0) {
//					Thread.yield();
//				}

                //take lock
                lock.lock();

                while (queue.size() == MAX_WORK_ITEMS_IN_QUEUE) {
                    // release lock and wait until queue has at least one available space.
                    queueFull.awaitUninterruptibly(); // await will release the lock
                }

                System.out.println("Adding work item: " + i + " to the queue.");
                queue.add(new Work(i));

                if (queue.size() == 1) {
                    queueEmpty.signal();
                }

                lock.unlock();
            }
        }

    }

    // Consumer thread
    private class ConsumerBC implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < MAX_WORK_ITEMS; i++) {

//				if (i % 7 == 0) {
//					Thread.yield();
//				}

                // take lock
                lock.lock();

                while (queue.size() == 0) {
                    // release lock and wait until there is at least one item in the queue
                    queueEmpty.awaitUninterruptibly();
                }

                Work w = queue.remove();
                System.out.println("Removing work item: " + w.getWorkId() + " from the queue.");

                if (queue.size() == MAX_WORK_ITEMS_IN_QUEUE - 1) {
                    queueFull.signal();
                }

                lock.unlock();
            }
        }
    }

    // Work class
    private class Work {
        private int workId;

        Work(int workId) {
            this.workId = workId;
        }

        public int getWorkId() {
            return workId;
        }

    }

    public static void main(String[] args) {

		/*
		 *  This queue will maintain all the work items produced by the producer thread
		 *  and consumed by the consumer thread
		 *  This is a shared resource between the two threads i.e. the two threads are
		 *  communicating with each other via this data structure.
		 */
        ProducerConsumer pc = new ProducerConsumer();

        // create producer and consumer threads and start them
        Thread producer = new Thread(pc.new ProducerBC());
        Thread consumer = new Thread(pc.new ConsumerBC());

        producer.setPriority(Thread.MIN_PRIORITY);
        consumer.setPriority(Thread.MAX_PRIORITY);

        consumer.start();
        producer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

