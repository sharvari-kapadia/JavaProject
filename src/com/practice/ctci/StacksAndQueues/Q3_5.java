/*
 * 11.26.2015
 * Implement a MyQueue class which implements a queue using two stacks.
 */

package com.practice.ctci.StacksAndQueues;

import com.practice.ctci.exceptions.QueueUnderflowException;

import java.util.Stack;

public class Q3_5<E> {

    private Stack<E> stack1;
    private Stack<E> stack2;

    Q3_5() {
        stack1 = new Stack<E>();
        stack2 = new Stack<E>();
    }

    public void enqueue(E item) {

        stack1.push(item);
    }

    public E dequeue() throws QueueUnderflowException {
        if(stack1.isEmpty() && stack2.isEmpty()) {
            throw new QueueUnderflowException("Queue is empty. No elements to dequeue.");
        }

        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    public void printQueue() {

        boolean isStack1Empty = stack1.isEmpty();
        boolean isStack2Empty = stack2.isEmpty();

        if(isStack1Empty && isStack2Empty) {
            System.out.println("Queue is empty. No elements to print.");
            return;
        }

        if(!stack2.isEmpty()) {
            for (int i = stack2.size() - 1; i >= 0; i--) {
                System.out.print(stack2.get(i));
                if (!isStack1Empty || (isStack1Empty && i > 0)) {
                    System.out.print(" - ");
                }
            }
        }

        if(!stack1.isEmpty()) {
            for (int i = 0; i < stack1.size(); i++) {
                System.out.print(stack1.get(i));
                if (i < stack1.size() - 1) {
                    System.out.print(" - ");
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Q3_5<Integer> queue = new Q3_5<Integer>();
        for(int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }

        queue.printQueue();

        try {
            queue.dequeue();
            queue.dequeue();
            queue.dequeue();
        } catch (QueueUnderflowException e) {
            e.printStackTrace();
        }

        for(int i = 5; i < 10; i++) {
            queue.enqueue(i);
        }
        queue.printQueue();
    }
}
