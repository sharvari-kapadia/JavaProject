/*
 * 11.26.2015
 * In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of different sizes which can slide onto
 * any tower. The puzzle starts with disks sorted in ascending order of size from top to bottom (i.e., each disk sits on
 * top of an even larger one). You have the following constraints:
 * (1) Only one disk can be moved at a time.
 * (2) A disk is slid off the top of one tower onto the next tower.
 * (3) A disk can only be placed on top of a larger disk.
 * Write a program to move the disks from the first tower to the last using stacks.
 */

package com.practice.ctci.StacksAndQueues;

import com.practice.ctci.exceptions.StackUnderflowException;
import com.practice.ctci.tools.OrderedStack;

public class Q3_4 {

    static final int numberOfTowers = 3;
    int numberOfDisks;
    public OrderedStack[] stack;

    Q3_4(int numberOfDisks) {

        this.numberOfDisks = numberOfDisks;
        stack = new OrderedStack[numberOfTowers];

        // Initialize the three towers of Hanai
        for(int i = 0; i < stack.length; i++) {
            stack[i] = new OrderedStack();
        }

        // Fill up the first one with N disks in ascending order
        for(int i = numberOfDisks - 1; i >= 0; i--) {
            stack[0].push(i);
        }
    }

    public void printTowers() {
        for(int i = 0; i < stack.length; i++) {
            System.out.print("Stack " + i + ": ");
            stack[i].printStack();
        }
    }

    public void move(int numberOfDisksToMove, int sourceTower, int destinationTower) throws StackUnderflowException {
        assert numberOfDisksToMove > 0 && numberOfDisksToMove <= numberOfDisks;

        if(numberOfDisksToMove == 1) {
            System.out.println("moving " + numberOfDisksToMove + " disk from tower " + sourceTower + " to " + destinationTower + ".");
            stack[destinationTower].push(stack[sourceTower].pop());
            return;
        }
        int bufferTower = numberOfTowers - (sourceTower + destinationTower);

        move(numberOfDisksToMove - 1, sourceTower, bufferTower);
        move(1, sourceTower, destinationTower);
        move(numberOfDisksToMove - 1, bufferTower, destinationTower);
    }

    public static void main(String[] args) {
        final int numberOfDisks = 5;
        Q3_4 towersOfHanai = new Q3_4(numberOfDisks);
        towersOfHanai.printTowers();
        System.out.println();

        try {
            towersOfHanai.move(numberOfDisks, 0, 2);
        } catch (StackUnderflowException e) {
            e.printStackTrace();
        }

        System.out.println();
        towersOfHanai.printTowers();
    }
}
