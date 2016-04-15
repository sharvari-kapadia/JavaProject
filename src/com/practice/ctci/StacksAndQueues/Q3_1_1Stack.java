/*
 * 11.16.2015
 * Describe how you could use a single array to implement one stack.
 */

package com.practice.ctci.StacksAndQueues;

import com.practice.ctci.exceptions.StackUnderflowException;

public class Q3_1_1Stack {

    private int[] array;
    private int maxSize;
    private int size;

    Q3_1_1Stack(int maxSize) {
        if(maxSize < 1) {
            throw new IllegalArgumentException("Max size of stack should at least be 1.");
        }
        array = new int[maxSize];
        this.maxSize = maxSize;
        this.size = 0;
    }

    public void push(int item) {
        if(size > maxSize - 1) {
            throw new StackOverflowError("The stack has reached its maximum size.");
        }
        array[size] = item;
        size++;
    }

    public int pop() throws StackUnderflowException {
        if(isEmpty()) {
            throw new StackUnderflowException("Stack is empty. No elements to pop.");
        }
        int item = array[size-1];
        size--;
        return item;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printStack() {

        if(isEmpty()) {
            System.out.println("Stack is empty. No elements to print.");
            return;
        }

        int size = size();
        for(int i = 0; i < size; i++) {
            System.out.print(i);
            if(i < size - 1) {
                System.out.print(" - ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Q3_1_1Stack oneStack = new Q3_1_1Stack(10);
        for(int i = 0; i < 10; i++) {
            oneStack.push(i);
        }

        oneStack.printStack();

        try {
            oneStack.pop();
            oneStack.pop();
            oneStack.pop();
        } catch (StackUnderflowException e) {
            e.printStackTrace();
        }

        System.out.print("Stack after popping three elements: ");
        oneStack.printStack();
    }
}
