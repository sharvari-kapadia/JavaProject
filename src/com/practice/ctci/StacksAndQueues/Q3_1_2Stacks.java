/*
 * 11.16.2015
 * Describe how you could use a single array to implement two stacks.
 */

package com.practice.ctci.StacksAndQueues;

import com.practice.ctci.exceptions.StackUnderflowException;

public class Q3_1_2Stacks {

    private int[] array;
    private int maxSize;
    private int index1;
    private int index2;
    private int size1;
    private int size2;

    Q3_1_2Stacks(int maxSize) {
        if(maxSize < 1) {
            throw new IllegalArgumentException("Max size of stack should at least be 1.");
        }
        array = new int[maxSize];
        this.maxSize = maxSize;
        index1 = 0;
        index2 = maxSize - 1;
        size1 = size2 = 0;
    }

    public void pushToStack1(int item) {
        if(index1 > index2) {
            throw new StackOverflowError("The stack has reached its maximum size.");
        }
        array[index1] = item;
        index1++;
        size1++;
    }

    public void pushToStack2(int item) {
        if(index2 < index1) {
            throw new StackOverflowError("The stack has reached its maximum size.");
        }
        array[index2] = item;
        index2--;
        size2++;
    }

    public int popFromStack1() throws StackUnderflowException {
        if(index1 < 0) {
            throw new StackUnderflowException("Stack1 is empty. No elements to pop.");
        }
        int item = array[index1-1];
        index1--;
        return item;
    }

    public int popFromStack2() throws StackUnderflowException {
        if(index2 > maxSize - 1) {
            throw new StackUnderflowException("Stack2 is empty. No elements to pop.");
        }
        int item = array[index2+1];
        index2++;
        return item;
    }

    public int stack1Size() {
        return size1;
    }

    public int stack2Size() {
        return size2;
    }

    public void printStacks() {
        printStack1();
        printStack2();
        System.out.println();
    }

    public void printStack1() {
        if(size1 == 0) {
            System.out.print("Stack1 is empty. ");
            return;
        }
        System.out.print("Stack1: ");
        for(int i = 0; i < index1; i++) {
            System.out.print(array[i]);
            if(i < index1 - 1) {
                System.out.print(" - ");
            }
        }
        System.out.print(" ");
    }

    public void printStack2() {
        if(size2 == 0) {
            System.out.print("Stack2 is empty. ");
            return;
        }
        System.out.print("Stack2: ");
        for(int i = maxSize-1; i > index2; i--) {
            System.out.print(array[i]);
            if(i > index2 + 1) {
                System.out.print(" - ");
            }
        }
        System.out.print(" ");
    }

    public static void main(String[] args) {
        Q3_1_2Stacks twoStacks = new Q3_1_2Stacks(10);
        for(int i = 0; i < 7; i++) {
            twoStacks.pushToStack1(i);
            twoStacks.pushToStack2(++i);
        }

        twoStacks.printStacks();

        try {
            twoStacks.popFromStack1();
            twoStacks.popFromStack1();
            twoStacks.popFromStack2();
            twoStacks.popFromStack2();
        } catch (StackUnderflowException e) {
            e.printStackTrace();
        }

        System.out.println("Stacks after popping two elements from each one:");
        twoStacks.printStacks();
    }
}
