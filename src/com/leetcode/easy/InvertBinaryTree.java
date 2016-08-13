package com.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by SKapadia on 6/27/2016.
 * https://leetcode.com/problems/invert-binary-tree/
 */
public class InvertBinaryTree {

    private enum Direction {
        LEFT, RIGHT
    }

    private class Node {

        int data;
        Node left;
        Node right;

        private Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    Node root;
    Direction lastDirection;

    InvertBinaryTree() {
        this.root = null;
        lastDirection = Direction.LEFT;
    }

    public Node getRoot() {
        return this.root;
    }

    private Direction getDirection() {
        if(lastDirection.equals(Direction.LEFT)) {
            lastDirection = Direction.RIGHT;
        } else {
            lastDirection = Direction.LEFT;
        }
        return lastDirection;
    }

    public void insert(int data) {

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
            } else if(current.right == null) {
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

    public Node createBinaryTree(ArrayList<Integer> dataList) {

        for(int i = 0; i < dataList.size(); i++) {
            this.insert(dataList.get(i));
        }

        return getRoot();
    }

    public Node invertTree(Node root) {
        if(root == null) {
            return root;
        }

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static void main(String[] args) {

        ArrayList<Integer> dataList = new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        InvertBinaryTree object = new InvertBinaryTree();
        Node root = object.createBinaryTree(dataList);
        Node oldLeft = root.left;
        Node oldRight = root.right;
        Node newRoot = object.invertTree(root);
        System.out.println();
    }
}
