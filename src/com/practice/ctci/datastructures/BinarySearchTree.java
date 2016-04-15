package com.practice.ctci.datastructures;

/**
 * Created by SKapadia on 11/30/2015.
 */
public class BinarySearchTree {

    private Node root;
    private enum Direction {
        LEFT, RIGHT
    };

    public BinarySearchTree() {
        root = null;
    }

    private class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    // IS INSERT
    public void insert(int item) {

        Node current = root;
        Node parent = null;
        Node node = new Node(item, null, null);
        Direction direction = Direction.LEFT; // LEFT -> false, RIGHT -> true

        if(root == null) {
            root = node;
        } else {
            while(current != null) {
                parent = current;
                if(item <= current.data) {
                    current = current.left;
                    direction = Direction.LEFT;
                } else {
                    current = current.right;
                    direction = Direction.RIGHT;
                }
            }
            if(direction.equals(Direction.LEFT)) {
                parent.left = node;
            } else {
                parent.right = node;
            }
        }
    }

    // IS BALANCED
    public boolean isBalanced() {
        return maxHeight() - minHeight() <= 1;
    }

    // IS BINARY SEARCH TREE
    public boolean isBinarySearchTree() {
        return _isBinarySearchTree(root);
    }

    private boolean _isBinarySearchTree(Node node) {

        if(node == null) {
            return true;
        }

        return this._isBinarySearchTree(node.left)
                && this._isBinarySearchTree(node.right)
                && this.isNodeGreaterThanSmallestNodeOnLeftSide(node)
                && this.isNodeLessThanLargestNodeOnRightSide(node);
    }

    private boolean isNodeGreaterThanSmallestNodeOnLeftSide(Node node) {

        if (node != null) {
            Node largestNodeOnLeftSide = this.getLargestNodeOnLeftSide(node);
            if(largestNodeOnLeftSide != null) {
                return node.data > largestNodeOnLeftSide.data;
            }
        }
        return true;
    }

    private boolean isNodeLessThanLargestNodeOnRightSide(Node node) {

        if (node != null) {
            Node smallestNodeOnRightSide = this.getSmallestNodeOnRightSide(node);
            if(smallestNodeOnRightSide != null) {
                return node.data < smallestNodeOnRightSide.data;
            }
        }
        return true;
    }

    private Node getLargestNodeOnLeftSide(Node node) {

        Node temp = node.left;
        while(temp != null && temp.right != null) {
            temp = temp.right;
        }
        return temp;
    }

    private Node getSmallestNodeOnRightSide(Node node) {

        Node temp = node.right;
        while(temp != null && temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }

    // HEIGHT
    public int maxHeight() {
        return _maxHeight(root);
    }

    private int _maxHeight(Node node) {
        if(node == null) {
            return 0;
        }

        return Math.max(_maxHeight(node.left), _maxHeight(node.right)) + 1;
    }

    public int minHeight() {
        return _minHeight(root);
    }

    private int _minHeight(Node node) {
        if(node == null) {
            return 0;
        }

        return Math.min(_minHeight(node.left), _minHeight(node.right)) + 1;
    }

    // PRINT
    public void print() {
        _print(root, 0);
    }

    private void _print(Node node, int height) {
        if(node == null) {
            return;
        }

        printDashes(height);
        System.out.println(node.data);
        height++;
        _print(node.left, height);
        _print(node.right, height);
    }

    private void printDashes(int height) {
        for(int i = 0; i < height; i++) {
            System.out.print("-");
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(7);
        tree.insert(5);
        tree.insert(12);
        tree.insert(3);
        tree.insert(6);
        tree.insert(9);
        tree.insert(15);
        tree.insert(1);
        tree.insert(4);
        tree.insert(8);
        tree.insert(10);
        tree.insert(13);
        tree.insert(17);
        tree.print();

        System.out.println("The max maxHeight of tree is: " + tree.maxHeight() + ".");
        System.out.println("The max minHeight of tree is: " + tree.minHeight() + ".");

        System.out.println(tree.isBalanced());
        System.out.println(tree.isBinarySearchTree());
    }
}
