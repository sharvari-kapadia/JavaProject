package com.util.datastructures;

import java.util.Stack;

/**
 * Created by SKapadia on 11/17/2015.
 */
public class StackUtil {

    public static void printStack(Stack stack) {

        if(stack.isEmpty()) {
            System.out.println("Stack is empty. No elements to print.");
            return;
        }

        int stackSize = stack.size();
        for(int i = 0; i < stackSize; i++) {
            System.out.print(stack.get(i));
            if(i < stackSize - 1) {
                System.out.print(" - ");
            } else {
                System.out.println();
            }
        }
    }
}
