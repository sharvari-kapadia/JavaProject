/*
 * 11.17.2015
 * How would you design a stack which, in addition to push and pop, also has a function min which returns the minimum
 * element? Push, pop and min should all operate in O(1) time.
 */

package com.practice.ctci.StacksAndQueues;

import com.practice.ctci.exceptions.StackUnderflowException;
import com.practice.ctci.datastructures.StackUtil;

import java.util.Stack;

public class Q3_2 {

    public Stack<Integer> stack;
    public Stack<Integer> minStack;

    public Q3_2() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(Integer item) {
        stack.push(item);
        if(minStack.isEmpty()) {
            minStack.push(item);
        } else if(item <= minStack.peek()) {
            minStack.push(item);
        }
    }

    public int pop() throws StackUnderflowException {
        if(stack.isEmpty()) {
            throw new StackUnderflowException("Stack is empty. No elements to pop.");
        }
        int item = stack.pop();
        if(!minStack.isEmpty() && minStack.peek().equals(item)) {
            minStack.pop();
        }
        return item;
    }

    public int getMin() throws StackUnderflowException {
        if(minStack.isEmpty()) {
            throw new StackUnderflowException("No items in minStack.");
        }
        return minStack.peek();
    }

    public static void main(String[] args) {
        Q3_2 myStack = new Q3_2();

        for (int i = 0; i < 10; i++) {
            myStack.push(i);
        }

        myStack.push(5);
        myStack.push(-5);
        StackUtil.printStack(myStack.stack);

        try {
            myStack.pop();
            System.out.println("Minimum item in stack is: " + myStack.getMin());
        } catch (StackUnderflowException e) {
            e.printStackTrace();
        }
    }
}
