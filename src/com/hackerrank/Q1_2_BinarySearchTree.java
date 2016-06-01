package com.hackerrank;

/**
 * Created with IntelliJ IDEA.
 * User: SKapadia
 * Date: 5/30/16
 * Time: 7:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class Q1_2_BinarySearchTree {

    class Node {
        Node left, right;
        int data;
        Node(int newData) {
            left = right = null;
            data = newData;
        }
    }

    private static int isPresent(Node root, int val){
        if(root == null) {
            return 0;
        }

        if(val == root.data) {
            return 1;
        }

        if(val <= root.data) {
            return isPresent(root.left, val);
        } else {
            return isPresent(root.right, val);
        }
    }
}
