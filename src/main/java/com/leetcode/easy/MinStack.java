package com.leetcode.easy;

import java.util.Stack;

/**
 * Created by skapadia on 10/13/2016.
 * https://leetcode.com/problems/min-stack/
 */
public class MinStack {

    Stack<Integer> primary;
    Stack<Integer> secondary;

    /** initialize your data structure here. */
    public MinStack() {
        primary = new Stack<>();
        secondary = new Stack<>();
    }

    public void push(int x) {
        if(secondary.isEmpty() || x <= secondary.peek()) {
            secondary.add(x);
        }
        primary.add(x);
    }

    public void pop() {
        if(primary.isEmpty()) {
            return;
        }
        int retVal = primary.pop();
        if(retVal == secondary.peek()) {
            secondary.pop();
        }
    }

    public int top() {
        return primary.peek();
    }

    public int getMin() {
        return secondary.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        assert -3 == minStack.getMin();   //--> Returns -3.
        minStack.pop();
        assert 0 == minStack.top();      //--> Returns 0.
        assert -2 == minStack.getMin();   //--> Returns -2.
    }
}
