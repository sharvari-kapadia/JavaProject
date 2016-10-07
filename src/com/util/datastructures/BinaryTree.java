package com.util.datastructures;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class BinaryTree {

    public Node root;
    private Random random;
    private Direction lastDirection;

    public BinaryTree() {
        root = null;
        random = new Random();
        lastDirection = Direction.LEFT;
    }

    private enum Direction {
        LEFT, RIGHT
    }

    public class Node {

        public int data;
        public Node left;
        public Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Direction getRandomDirection() {
        if(random.nextBoolean()) {
            return Direction.LEFT;
        } else {
            return Direction.RIGHT;
        }
    }

    private Direction getDirection() {
        if(lastDirection.equals(Direction.LEFT)) {
            lastDirection = Direction.RIGHT;
        } else {
            lastDirection = Direction.LEFT;
        }
        return lastDirection;
    }

    public void insert(int item) {

        Node node = new Node(item);
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
                Direction direction = getRandomDirection();
                //Direction direction = getDirection();

                if(direction.equals(Direction.LEFT)) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }
        }
    }

    public void insert2(int item) {

        Node node = new Node(item);
        if(root == null) {
            root = node;
            return;
        }

        Node current = root;

        while(current != null) {

            //Direction direction = getRandomDirection();
            Direction direction = getDirection();

            if(direction.equals(Direction.LEFT)) {
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

    public void printBreadthWise() {

        class NodeAndLevel {
            Node node;
            int level;

            NodeAndLevel(Node node, int level) {
                this.node = node;
                this.level = level;
            }
        }

        NodeAndLevel currentNodeAndLevel;
        Node currentNode;
        int currentLevel;
        int level = 0;

        Queue<NodeAndLevel> q = new LinkedList<>();
        q.add(new NodeAndLevel(root, level));

        while (!q.isEmpty()) {

            currentNodeAndLevel = q.remove();
            currentNode = currentNodeAndLevel.node;
            currentLevel = currentNodeAndLevel.level;

            if (level == currentLevel) {

            } else {
                level = currentLevel;
                System.out.println();
            }

            System.out.print(currentNode.data + " ");

            if (currentNode.left != null) {
                q.add(new NodeAndLevel(currentNode.left, currentLevel + 1));
            }

            if (currentNode.right != null) {
                q.add(new NodeAndLevel(currentNode.right, currentLevel + 1));
            }

        }
    }

    public int getHeight() {
        return _getHeight(root);
    }

    private int _getHeight(Node node) {

        if (node == null) {
            return 0;
        }

        return Math.max(_getHeight(node.left), _getHeight(node.right)) + 1;
    }

    public boolean isBalanced() {
        return _isBalanced(root);
    }

    private boolean _isBalanced(Node node) {

        if(node == null) {
            return true;
        }

        return !(_getHeight(node.left) - _getHeight(node.right) > 1);
    }
}
