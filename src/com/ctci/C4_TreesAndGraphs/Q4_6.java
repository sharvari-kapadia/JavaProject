/*
 * 6.8.2015
 * Write an algorithm to find the 'next' node (i.e., in-order successor) of a given node in a binary search tree. You
 * may assume that each node has a link to its parent.
 */

package com.ctci.C4_TreesAndGraphs;

import java.util.ArrayList;
import java.util.Arrays;

public class Q4_6 {

    private class Node {

        int data;
        Node parent;
        Node left;
        Node right;

        private Node(int data, Node parent) {
            this.data = data;
            this.parent = parent;
            this.left = null;
            this.right = null;
        }
    }

    Node root = null;

    public class BinarySearchTree {

        private BinarySearchTree() {
            root = null;
        }

        private Node getRoot() {
            return root;
        }

        private void insert(int data) {

            if(root == null) {
                root = new Node(data, null);
                return;
            }

            Node current = root;
            while(current != null) {

                if(data <= current.data) {

                    if(current.left == null) {
                        current.left = new Node(data, current);
                        return;
                    } else {
                        current = current.left;
                    }

                } else {

                    if(current.right == null) {
                        current.right = new Node(data, current);
                        return;
                    } else {
                        current = current.right;
                    }

                }
            }
        }
    }

    public Node createBinarySearchTree(ArrayList<Integer> dataList) {

        BinarySearchTree tree = new BinarySearchTree();
        for(int i : dataList) {
            tree.insert(i);
        }

        return tree.getRoot();
    }

    public Node search(Node root, int data) {

        Node current = root;
        while(current != null) {

            if(data == current.data) {
                return current;
            } else if(data < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

    public Node getNextInOrderSuccessor(Node node) {

        if(node == null) {
            return null;
        }

        Node current = node;
        if(node.right != null) {
            current = current.right;
            while(current != null && current.left != null) {
                current = current.left;
            }
            return current;
        } else {

            Node parent = current.parent;
            while(parent != null) {

                if(current == parent.left) {
                    return parent;
                } else if(current == parent.right) {
                    current = parent;
                    parent = current.parent;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {

        Q4_6 q4_6 = new Q4_6();
        Node tree1 = q4_6.createBinarySearchTree(new ArrayList<>(Arrays.asList(8, 4, 2, 1, 3, 6, 5, 7, 12, 10, 9, 11, 14, 13, 15)));
        Node inOrderSuccessor = q4_6.getNextInOrderSuccessor(q4_6.search(tree1, 11));
        if(inOrderSuccessor == null) {
            System.out.println("null");
        } else {
            System.out.println(inOrderSuccessor.data);
        }
    }
}
