package com.practice.ctci.datastructures;

import java.util.Random;

/**
 * Created by SKapadia on 3/3/2016.
 */
public class BinaryTree {

    private Node root;
    private Random random;

    public BinaryTree() {
        root = null;
        random = new Random();
    }

    private enum Direction {
        LEFT, RIGHT;
    }

    private class Node {

        private int data;
        private Node left;
        private Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public void insert(int item) {

        Node node = new Node(item);
        if(root == null) {
            root = node;
        } else {

        }
    }

    private Direction getRandomDirection() {
        if(random.nextBoolean()) {
            return Direction.LEFT;
        } else {
            return Direction.RIGHT;
        }
    }

    public boolean isBalanced() {
        return false;
    }


}
