package com.practice;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by SKapadia on 10/26/2016.
 */
public class DepthWisePathSum {

    private class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    private enum Direction {
        LEFT, RIGHT
    }

    private class BinaryTree {
        private Node root;
        private Direction lastDirection;

        private BinaryTree() {
            root = null;
            lastDirection = Direction.LEFT;
        }

        private Direction getDirection() {
            if (lastDirection.equals(Direction.LEFT)) {
                lastDirection = Direction.RIGHT;
            } else {
                lastDirection = Direction.LEFT;
            }
            return lastDirection;
        }

        private Node getRoot() {
            return root;
        }

        private void insert(int data) {
            Node node = new Node(data);
            if (root == null) {
                root = node;
                return;
            }

            Node current = root;
            while (current != null) {
                if (current.left == null) {
                    current.left = node;
                    return;
                } else if (current.right == null) {
                    current.right = node;
                    return;
                } else {

                    if (getDirection().equals(Direction.LEFT)) {
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
        for (int i : dataList) {
            tree.insert(i);
        }
        return tree.getRoot();
    }

    public int getSum(Node root) {
        int sum = 0;
        if (root == null) {
            return sum;
        }

        int num = root.val;
        return _getSum(root, sum, num);
    }

    private int _getSum(Node node, int sum, int num) {
        if (node.left == null && node.right == null) {
            sum += num;
            return sum;
        }

        if (node.left != null) {
            num = (num * 10) + node.left.val;
            sum = _getSum(node.left, sum, num);
            num = num / 10;
        }

        if (node.right != null) {
            num = (num * 10) + node.right.val;
            sum = _getSum(node.right, sum, num);
            num = num / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        DepthWisePathSum object = new DepthWisePathSum();
        Node root = object.createBinaryTree(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
        System.out.println(object.getSum(root));
    }
}
