/*
 * 11.30.2015
 * Implement a function to check if a binary tree is a binary search tree.
 */

package com.ctci.C4_TreesAndGraphs;

import com.util.datastructures.BinarySearchTree;

public class Q4_5 {


    private BinarySearchTree tree;

    Q4_5() {
        tree = new BinarySearchTree();
        tree.insert(7);
        tree.insert(5);
        tree.insert(12);
        tree.insert(3);
        tree.insert(6);
        tree.insert(9);
        tree.insert(15);
        tree.insert(1);
        tree.insert(4);
        tree.insert(8);
        tree.insert(10);
        tree.insert(13);
        tree.insert(17);
    }

    public boolean isBinarySearchTree() {
        return tree.isBinarySearchTree();
    }

    public void printTree() {
        tree.print();
    }

    public static void main(String[] args) {
        Q4_5 tree = new Q4_5();
        tree.printTree();
        if(tree.isBinarySearchTree()) {
            System.out.println("The tree IS a binary search tree.");
        } else {
            System.out.println("The tree IS NOT a binary search tree.");
        }
    }
}
