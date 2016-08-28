package com.questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
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
    private Direction lastDirection = Direction.RIGHT;
    private enum Direction {
        LEFT, RIGHT
    }

    SameLevelSumInTree() {
        root = null;
    }

    private Direction getDirection() {

        // for random tree
        if(new Random().nextBoolean()) {
            return Direction.LEFT;
        } else {
            return Direction.RIGHT;
        }

        // for fixed tree
        /*if(lastDirection.equals(Direction.RIGHT)) {
            lastDirection = Direction.LEFT;
        } else {
            lastDirection = Direction.RIGHT;
        }
        return lastDirection;*/
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
    }

    public void printSameLevelSum() {

        ArrayList<Integer> sumList = new ArrayList<>();

        if(root == null) {
            return;
        }

        Queue<Node> primaryQueue = new LinkedList<>();
        Queue<Node> secondaryQueue = new LinkedList<>();
        Queue<Node> temp;
        Node node;
        primaryQueue.add(root);

        while(!primaryQueue.isEmpty() || !secondaryQueue.isEmpty()) {

            int sum = 0;
            while(!primaryQueue.isEmpty()) {
                node = primaryQueue.remove();
                sum += node.data;

                if(node.left != null) {
                    secondaryQueue.add(node.left);
                }

                if(node.right != null) {
                    secondaryQueue.add(node.right);
                }
            }
            sumList.add(sum);

            temp = primaryQueue;
            primaryQueue = secondaryQueue;
            secondaryQueue = temp;
        }

        System.out.println(sumList.toString());
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

        tree.printSameLevelSum();
    }

}
