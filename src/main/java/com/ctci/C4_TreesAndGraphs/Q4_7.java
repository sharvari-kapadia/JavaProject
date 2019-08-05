/*
 * 6.8.2015
 * Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree. Avoid storing
 * additional nodes in a data structure. NOTE: This is not necessarily a binary search tree.
 */

package com.ctci.C4_TreesAndGraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q4_7 {

    private class Node {

        int data;
        Node parent;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        Node(int data, Node parent) {
            this.data = data;
            this.parent = parent;
            this.left = null;
            this.right = null;
        }
    }

    private enum Direction {
        LEFT, RIGHT
    }

    /* BinarySearchTree START */
    private class BinarySearchTree {

        Node root;
        private BinarySearchTree() {
            this.root = null;
        }

        private Node getRoot() {
            return root;
        }

        private void insert(int data) {

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
    }

    public Node createBinarySearchTree(ArrayList<Integer> dataList) {

        BinarySearchTree tree = new BinarySearchTree();
        for(int i : dataList) {
            tree.insert(i);
        }
        return tree.getRoot();
    }

    private Node searchInBST(Node root, int data) {
        if(root == null) {
            return null;
        }

        Node current = root;
        while(current != null) {
            if(data == current.data) {
                return current;
            } else if (data < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return null;
    }

    public Node getCommonAncestorInBST(Node root, Node node1, Node node2) {

        if(root == null || node1 == null || node2 == null) {
            return null;
        }

        Node current = root;
        while(current != null) {

            if(node1.data == current.data && node2.data == current.data) {
                return current;
            } else if(node1.data < current.data && node2.data < current.data) {
                current = current.left;
            } else if(node1.data > current.data && node2.data > current.data) {
                current = current.right;
            } else {
                return current;
            }
        }

        return null;
    }
    /* BinarySearchTree END */

    /* BinaryTree START */
    private class BinaryTree {

        Node root;
        Direction lastDirection;

        private BinaryTree() {
            this.root = null;
            lastDirection = Direction.LEFT;
        }

        private Node getRoot() {
            return root;
        }

        private Direction getDirection() {

            if(lastDirection.equals(Direction.LEFT)) {
                lastDirection = Direction.RIGHT;
            } else {
                lastDirection = Direction.LEFT;
            }
            return lastDirection;
        }

        private void insert(int data) {

            if(root == null) {
                root = new Node(data, null);
                return;
            }

            Node current = root;
            while(current != null) {

                if(current.left == null) {
                    current.left = new Node(data, current);
                    return;
                } else if(current.right == null) {
                    current.right = new Node(data, current);
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

    public Node createBinaryTree(ArrayList<Integer> dataList) {

        BinaryTree tree = new BinaryTree();
        for(int i : dataList) {
            tree.insert(i);
        }
        return tree.getRoot();
    }

    private Node searchInBT(Node root, int data) {
        if(root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node current;

        while(!queue.isEmpty()) {

            current = queue.remove();

            if(current.data == data) {
                return current;
            }

            if(current.left != null) {
                queue.add(current.left);
            }
            if(current.right != null) {
                queue.add(current.right);
            }
        }

        return null;
    }

    private int getLengthInBT(Node root, Node node) {

        if(root == null) {
            return 0;
        }

        Node current;
        Node parent = node.parent;
        int length = 0;

        while(parent != null) {
            current = parent;
            parent = current.parent;
            length++;
        }
        return length;
    }

    private Node moveStepsUp(Node node, int steps) {

        Node current = node;
        Node parent = current.parent;
        for(int i = 0; i < steps - 1; i++) {
            current = parent;
            parent = current.parent;
        }
        return parent;
    }

    public Node getCommonAncestorInBT(Node root, Node node1, Node node2) {

        if(root == null || node1 == null || node2 == null) {
            return null;
        }

        int len1 = getLengthInBT(root, node1);
        int len2 = getLengthInBT(root, node2);
        int diff;
        if(len2 > len1) {
            diff = len2 - len1;
            node2 = moveStepsUp(node2, diff);
        } else if(len1 > len2) {
            diff = len1 - len2;
            node1 = moveStepsUp(node1, diff);
        }

        Node current1 = node1;
        Node current2 = node2;

        while(current1 != current2) {
            current1 = current1.parent;
            current2 = current2.parent;
        }
        return current1;
    }

    public static void main(String[] args) {

        Q4_7 q4_7 = new Q4_7();

        ArrayList<Integer> dataList1 = new ArrayList<>(Arrays.asList(8, 4, 2, 1, 3, 6, 5, 7, 12, 10, 9, 11, 14, 13, 15));
        Node tree1 = q4_7.createBinarySearchTree(dataList1);
        Node commonAncestor1 = q4_7.getCommonAncestorInBST(tree1, q4_7.searchInBST(tree1, 1), q4_7.searchInBST(tree1, 7));
        if(commonAncestor1 == null) {
            System.out.println("null");
        } else {
            System.out.println(commonAncestor1.data);
        }

        ArrayList<Integer> dataList2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        Node tree2 = q4_7.createBinaryTree(dataList2);
        Node commonAncestor2 = q4_7.getCommonAncestorInBT(tree2, q4_7.searchInBT(tree2, 6), q4_7.searchInBT(tree2, 2));
        if(commonAncestor2 == null) {
            System.out.println("null");
        } else {
            System.out.println(commonAncestor2.data);
        }
    }
}
