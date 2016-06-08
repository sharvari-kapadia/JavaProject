/*
 * 6.7.2015
 * Implement a function to check if a binary tree is a binary search tree.
 */

package com.ctci.C4_TreesAndGraphs;

import java.util.ArrayList;
import java.util.Arrays;

public class Q4_5 {

    private class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private enum Direction {
        LEFT, RIGHT
    }

    private class BinaryTree {

        Node root;
        Direction lastDirection;

        private BinaryTree() {
            root = null;
            lastDirection = Direction.LEFT;
        }

        private Direction getDirection() {
             if(lastDirection.equals(Direction.LEFT)) {
                 lastDirection = Direction.RIGHT;
             } else {
                 lastDirection = Direction.LEFT;
             }
            return lastDirection;
        }

        private Node getRoot() {
             return root;
        }

        private void insertAsInBST(int data) {

            Node node = new Node(data);
            if(root == null) {
                root = node;
                return;
            }

            Node current = root;
            while(current != null) {
                if(data <= current.data) {
                    if(current.left == null) {
                        current.left = node;
                        return;
                    } else {
                        current = current.left;
                    }
                } else {
                    if(current.right == null) {
                        current.right = node;
                        return;
                    } else {
                        current = current.right;
                    }
                }
            }
        }

        private void insertAsInTree(int data) {

            Node node = new Node(data);
            if(root == null) {
                root = node;
                return;
            }

            Node current = root;
            while(current != null) {
                if(current.left == null) {
                    current.left = node;
                    return;
                } else if (current.right == null) {
                    current.right = node;
                    return;
                } else {
                    if(getDirection().equals(Direction.LEFT)) {
                        current = current.left;
                    } else {
                        current = current.right;
                    }
                }
            }
        }
    }

    public Node createBinarySearchTree(ArrayList<Integer> dataList) {
        BinaryTree tree = new BinaryTree();
        for(int i : dataList) {
            tree.insertAsInBST(i);
        }
        return tree.getRoot();
    }

    public Node createBinaryTree(ArrayList<Integer> dataList) {
        BinaryTree tree = new BinaryTree();
        for(int i : dataList) {
            tree.insertAsInTree(i);
        }
        return tree.getRoot();
    }

    public boolean isBinarySearchTree(Node node) {

        if(node == null) {
            return true;
        }

        return isBinarySearchTree(node.left)
                && isBinarySearchTree(node.right)
                && isNodeGreaterThanSmallestNodeOnLeft(node)
                && isNodeSmallerThanLargestNodeOnRight(node);
    }

    private boolean isNodeGreaterThanSmallestNodeOnLeft(Node node) {

        if(node == null) {
            return true;
        }

        Node current = node;
        if(node.left != null) {
            current = current.left;

            while(current != null && current.right != null) {
                current = current.right;
            }

            return node.data >= current.data;
        }
        return true;
    }

    private boolean isNodeSmallerThanLargestNodeOnRight(Node node) {

        if(node == null) {
            return true;
        }

        Node current = node;
        if(node.right != null) {
            current = current.right;

            while(current != null && current.left != null) {
                current = current.left;
            }

            return node.data < current.data;
        }
        return true;
    }

    public static void main(String[] args) {
        Q4_5 q4_5 = new Q4_5();
        ArrayList<Integer> dataList = new ArrayList<>(Arrays.asList(5, 2, 1, 3, 4, 7, 6, 8, 9));

        if(q4_5.isBinarySearchTree(q4_5.createBinarySearchTree(dataList))) {
            System.out.println("tree1 IS a binary search tree.");
        } else {
            System.out.println("tree1 IS NOT a binary search tree.");
        }

        if(q4_5.isBinarySearchTree(q4_5.createBinaryTree(dataList))) {
            System.out.println("tree2 IS a binary search tree.");
        } else {
            System.out.println("tree2 IS NOT a binary search tree.");
        }
    }
}
