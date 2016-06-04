package com.practice;

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

        class NodeAndLevel {

            Node node;
            int level;

            NodeAndLevel(Node node, int level) {
                this.node = node;
                this.level = level;
            }
        }

        int currentLevel = 0;
        int sum = 0;
        NodeAndLevel nodeAndLevel;
        Node node;
        int level;

        Queue<NodeAndLevel> queue = new LinkedList<NodeAndLevel>();
        queue.add(new NodeAndLevel(root, currentLevel));

        while(!queue.isEmpty()) {

            nodeAndLevel = queue.remove();
            node = nodeAndLevel.node;
            level = nodeAndLevel.level;

            if(level == currentLevel) {
                sum = sum + node.data;
            } else {
                currentLevel++;
                System.out.println(sum);
                sum = node.data;
            }

            level++;
            if(node.left != null) {
                queue.add(new NodeAndLevel(node.left, level));
            }

            if(node.right != null) {
                queue.add(new NodeAndLevel(node.right, level));
            }
        }
        // printing the last sum
        System.out.println(sum);

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
