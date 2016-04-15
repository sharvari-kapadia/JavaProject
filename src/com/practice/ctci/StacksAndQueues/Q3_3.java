/*
 * 11.18.2015
 * Imagine a (literal) stack of plates. If the stack gets too high, it might topple. Therefore, in real life, we would
 * likely start a new stack when the previous stack exceeds some threshold. Implement a data structure SetOfStacks that
 * mimics this. SetOfStacks should be composed of several stacks and should create a new stack once the previous one
 * exceeds capacity. SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack (that is,
 * pop() should return the same values as it would if there were just a single stack).
 * FOLLOW UP
 * Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
 */

package com.practice.ctci.StacksAndQueues;

import com.practice.ctci.exceptions.StackUnderflowException;
import com.practice.ctci.datastructures.StackUtil;

import java.util.ArrayList;
import java.util.Stack;

public class Q3_3<E> {

    private ArrayList<Stack<E>> setOfStacks;
    int maxSizeOfEachStack;

    Q3_3(int maxSizeOfEachStack) {
        setOfStacks = new ArrayList<Stack<E>>();
        this.maxSizeOfEachStack = maxSizeOfEachStack;
    }

    public void push(E item) {
        // IF the setOfStack is empty create a new stack and push the item to it
        if(setOfStacks.isEmpty()) {
            Stack<E> stack = new Stack<E>();
            stack.push(item);
            setOfStacks.add(stack);
        } else {
            Stack currentStack = setOfStacks.get(setOfStacks.size() - 1);
            // ELSE IF the current stack is full create a new stack and push the item to it
            if (isFull(currentStack)) {
                Stack<E> stack = new Stack<E>();
                stack.push(item);
                setOfStacks.add(stack);
            }
            // ELSE push the item to current stack
            else {
                currentStack.push(item);
            }
        }
    }

    public E pop() throws StackUnderflowException {
        if(setOfStacks.isEmpty()) {
            throw new StackUnderflowException("Stack is empty. No elements to pop.");
        }
        int currentStackIndex = setOfStacks.size() - 1;
        Stack currentStack = setOfStacks.get(currentStackIndex);
        E item = (E) currentStack.pop();
        if(currentStack.isEmpty()) {
            setOfStacks.remove(currentStack);
        }

        return item;
    }

    // This API performs pop operation on a specific sub-stack.
    public E popAt(int index) {
        if(index < 0 || index >= setOfStacks.size()) {
            throw new IllegalArgumentException("No stack found at index " + index + ".");
        }
        Stack currentStack = setOfStacks.get(index);
        assert !currentStack.isEmpty();

        E item = (E) currentStack.pop();
        if(currentStack.isEmpty()) {
            setOfStacks.remove(index);
        }
        return item;
    }

    private boolean isFull(Stack<E> stack) {
        return stack.size() >= maxSizeOfEachStack;
    }

    public void printSetOfStacks() {
        for(int i = 0; i < setOfStacks.size(); i++) {
            StackUtil.printStack(setOfStacks.get(i));
        }
    }

    public static void main(String[] args) {
        int maxSizeOfEachStack = 5;
        Q3_3<Integer> setOfStacks = new Q3_3<Integer>(maxSizeOfEachStack);
        for(int i = 0; i < 7; i++) {
            setOfStacks.push(i);
        }

        try {
            setOfStacks.popAt(0);
            setOfStacks.popAt(0);
            setOfStacks.popAt(0);
            setOfStacks.popAt(0);
            setOfStacks.popAt(0);
            setOfStacks.popAt(0);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        setOfStacks.printSetOfStacks();
    }
}
