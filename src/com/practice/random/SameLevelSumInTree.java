package com.practice.random;

import java.util.Random;

/**
 * Created by SKapadia on 4/25/2016.
 */
public class SameLevelSumInTree {

    private class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    private Node root;
    private enum Direction {
        LEFT, RIGHT;
    }

    SameLevelSumInTree() {
        root = null;
    }

    private Direction getDirection() {
        if(new Random().nextBoolean()) {
            return Direction.LEFT;
        } else {
            return Direction.RIGHT;
        }
    }

    public void addNode(int data) {

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
        return;
    }

    public static void main(String[] args) {
        SameLevelSumInTree tree = new SameLevelSumInTree();
        tree.addNode(1);
        tree.addNode(2);
        tree.addNode(3);
        tree.addNode(4);
        tree.addNode(5);
        tree.addNode(6);
        tree.addNode(7);
        tree.addNode(8);
        tree.addNode(9);
        tree.addNode(10);
        tree.addNode(11);
        tree.addNode(12);

        System.out.println();
    }

}
