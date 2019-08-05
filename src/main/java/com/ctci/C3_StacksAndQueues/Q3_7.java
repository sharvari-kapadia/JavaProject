/*
 * 11.28.2015
 * An animal shelter holds only dogs and cats, and operates on a strictly "first in, first out" basis. People must adopt
 * either the "oldest" (based on arrival time) of all animals at the shelter, or they can select whether they would
 * prefer a dog or a cat (and will receive the oldest animal of that type). They cannot select which specific animal
 * they would like. Create the data structures to maintain this system and implement operations such as enqueue,
 * dequeueAny, dequeueDog and dequeueCat.You may use the built-in LinkedList data structure.
 */

package com.ctci.C3_StacksAndQueues;

import com.util.exceptions.QueueUnderflowException;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Q3_7 {

    private enum AnimalType {
        Cat, Dog
    }

    private static class Item {
        private String name;
        private AnimalType type;

        Item(String name, AnimalType type) {
            this.name = name;
            this.type = type;
        }
    }

    private Queue<Item> queue;

    Q3_7() {
        queue = new LinkedList<Item>();
    }

    public void enqueue(String name, AnimalType type) {
        Item item = new Item(name, type);
        queue.add(item);
    }

    public String dequeueAny() throws QueueUnderflowException {

        if(queue.isEmpty()) {
            throw new QueueUnderflowException("Queue is empty. No elements to queue.");
        }

        return queue.remove().name;
    }

    private String dequeue(AnimalType type) throws QueueUnderflowException {
        if(queue.isEmpty()) {
            throw new QueueUnderflowException("Queue is empty. No elements to queue.");
        }

        AnimalType currentType = queue.peek().type;
        int numberOfItemsDequeued = 0;
        int queueSize = queue.size();
        while(!currentType.equals(type) && numberOfItemsDequeued < (queueSize-1)) {
            queue.add(queue.remove());
            numberOfItemsDequeued++;
            currentType = queue.peek().type;
        }

        currentType = queue.peek().type;
        if(!currentType.equals(type)) {
            throw new QueueUnderflowException("No animals of type " + type + " in the queue.");
        }
        String name = queue.remove().name;

        for(int i = numberOfItemsDequeued; i < (queueSize-1); i++) {
            queue.add(queue.remove());
        }
        return name;
    }

    public String dequeueCat() throws QueueUnderflowException {
        return dequeue(AnimalType.Cat);
    }

    public String dequeueDog() throws QueueUnderflowException {
        return dequeue(AnimalType.Dog);
    }

    public void printQueue() {

        Iterator<Item> iterator = queue.iterator();
        while(iterator.hasNext()) {
            System.out.print(iterator.next().name);
            if(iterator.hasNext()) {
                System.out.print(" - ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) throws QueueUnderflowException {
        Q3_7 queue = new Q3_7();
        queue.enqueue("C1", AnimalType.Cat);
        queue.enqueue("C2", AnimalType.Cat);
        queue.enqueue("C3", AnimalType.Cat);
        queue.enqueue("D1", AnimalType.Dog);
        queue.enqueue("D2", AnimalType.Dog);
        queue.enqueue("C4", AnimalType.Cat);
        queue.enqueue("C5", AnimalType.Cat);
        queue.enqueue("C6", AnimalType.Cat);

        queue.printQueue();

        queue.dequeueDog();
        queue.dequeueCat();
        queue.dequeueAny();

        queue.printQueue();
    }
}
