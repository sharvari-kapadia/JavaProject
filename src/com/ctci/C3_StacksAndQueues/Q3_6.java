/*
 * 11.27.2015
 * Write a program to sort a stack in ascending order (with biggest items on top). You may use at most one additional
 * stack to hold items, but you may not copy the elements into any other data structure (such as an array). The stack
 * supports the following operations: push, pop, peek, and isEmpty.
 */

package com.ctci.C3_StacksAndQueues;

import com.util.datastructures.StackUtil;

import java.util.Stack;

public class Q3_6 {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    Q3_6() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    public void push(int item) {
        stack1.push(item);
    }

    public int pop() {
        return stack1.pop();
    }

    public int peek() {
        return stack1.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }

    public void sort() {

        if(stack1.isEmpty()) {
            return;
        }
        stack2.push(stack1.pop());

        int itemToPush;
        int itemToCompare;

        while(!stack1.isEmpty()) {
            itemToPush = stack1.pop();
            itemToCompare = stack2.peek();

            if (itemToPush > itemToCompare) {
                // transfer elements from stack2 to stack1
                int numberOfItemsTransferred = transferItemsFromStack2ToStack1(itemToPush);

                stack2.push(itemToPush);

                // transfer elements back from stack1 to stack2
                transferItemsFromStack1ToStack2(numberOfItemsTransferred);
            } else {
                stack2.push(itemToPush);
            }
        }

        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    private int transferItemsFromStack2ToStack1(int itemToPush) {

        int itemToCompare = stack2.peek();
        int numberOfItemsTransferred = 0;

        while(itemToPush > itemToCompare) {
            stack1.push(stack2.pop());
            numberOfItemsTransferred++;
            if(!stack2.isEmpty()) {
                itemToCompare = stack2.peek();
            } else {
                break;
            }
        }

        return numberOfItemsTransferred;
    }

    private void transferItemsFromStack1ToStack2(int numberOfItemsToBeTransferred) {

       for(int i = 0; i < numberOfItemsToBeTransferred; i++) {
           stack2.push(stack1.pop());
       }
    }

    public void printStack() {
        StackUtil.printStack(stack1);
    }

    public static void main(String[] args) {
        Q3_6 stack = new Q3_6();

        stack.push(2);
        stack.push(3);
        stack.push(5);
        stack.push(0);
        stack.push(1);
        stack.push(6);

        System.out.print("Stack before sorting: ");
        stack.printStack();

        stack.sort();

        System.out.print("Stack after sorting: ");
        stack.printStack();
    }
}
