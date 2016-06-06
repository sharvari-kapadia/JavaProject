/*
 * 6.4.2015
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

        // case1
        BinaryTree tree = new BinaryTree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);

        if(Q4_1.isBalanced(tree)) {
            System.out.println("The tree IS balanced.");
        } else {
            System.out.println("The tree IS NOT balanced.");
        }

        System.out.println();

        // case2
        BinaryTree tree2 = new BinaryTree();
        tree2.insert2(1);
        tree2.insert2(2);
        tree2.insert2(3);
        tree2.insert2(4);
        tree2.insert2(5);

        if(Q4_1.isBalanced(tree2)) {
            System.out.println("The tree IS balanced.");
        } else {
            System.out.println("The tree IS NOT balanced.");
        }
    }
}
