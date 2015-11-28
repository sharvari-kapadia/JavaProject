package com.practice.ctci.tools;

import com.practice.ctci.exceptions.StackUnderflowException;

import java.util.Stack;

/**
 * Created by SKapadia on 11/26/2015.
 * This stack is used for Tower of Hanai problem (Q3_4).
 * An item can be pushed to the stack only if its less than the topmost item of the stack.
 */
public class OrderedStack {

    Stack<Integer> myStack;

    public OrderedStack() {
        myStack = new Stack<Integer>();
    }

    public void push(int item) {
        if(((!myStack.isEmpty()) && (item <= myStack.peek())) || myStack.isEmpty()) {
            myStack.push(item);
        } else {
            throw new IllegalArgumentException("This item cannot be pushed to the stack since it is larger than the " +
                    "topmost item of the stack.");
        }
    }

    public int pop() throws StackUnderflowException {
        if(myStack.isEmpty()) {
            throw new StackUnderflowException("Stack is empty. No elements to pop.");
        }
        return myStack.pop();
    }

    public void printStack() {
        StackUtil.printStack(myStack);
    }
}
