/*
 * 11.30.2015
 * Implement a function to check if a binary tree is balanced. For the purposes of this question, a balanced tree is
 * defined to be a tree such that the heights of the two subtrees of any node never differ by more than one.
*/

package com.ctci.C4_TreesAndGraphs;

import com.util.datastructures.BinarySearchTree;
import com.util.datastructures.BinaryTree;

public class Q4_1 {

    private BinarySearchTree tree;

    Q4_1() {
    }

    public static boolean isBalanced(BinarySearchTree tree) {

        return tree.isBalanced();
    }

    public static boolean isBalanced(BinaryTree tree) {

        return tree.isBalanced();
    }

    public static void main(String[] args) {

        // Positive use case
        BinarySearchTree tree = new BinarySearchTree();
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
        tree.print();

        if(Q4_1.isBalanced(tree)) {
            System.out.println("The tree IS balanced.");
        } else {
            System.out.println("The tree IS NOT balanced.");
        }

        // Negative use case
        BinaryTree tree2 = new BinaryTree();
        tree2.insert(7);
        tree2.insert(5);
        tree2.insert(12);
        tree2.insert(3);
        tree2.insert(6);
        tree2.insert(9);
        tree2.insert(15);
        tree2.insert(1);
        tree2.insert(4);
        tree2.insert(8);
        tree2.insert(10);
        tree2.insert(13);
        tree2.insert(17);
        //tree2.print();

        if(Q4_1.isBalanced(tree2)) {
            System.out.println("The tree IS balanced.");
        } else {
            System.out.println("The tree IS NOT balanced.");
        }
    }
}
