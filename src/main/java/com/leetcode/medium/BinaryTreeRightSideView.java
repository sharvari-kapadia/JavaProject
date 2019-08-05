package com.leetcode.medium;

import java.util.*;

/**
 * Created by SKapadia on 8/23/2016.
 * https://leetcode.com/problems/binary-tree-right-side-view/
 */
public class BinaryTreeRightSideView {

    public class Node {
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

    public class BinaryTree {

        Node root;
        public BinaryTree() {

            this.root = null;
        }

        public void insert(int value) {

            Node node = new Node(value);
            if(root == null) {
                root = node;
                return;
            }

            Node current = root;
            Direction direction;
            while(current != null) {

                if(value <= current.data) {
                    direction = Direction.LEFT;
                } else {
                    direction = Direction.RIGHT;
                }

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
    }


    public List<Integer> rightSideView(Node root) {

        List<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        Queue<Node> primaryQueue = new LinkedList<>();
        Queue<Node> secondaryQueue = new LinkedList<>();

        primaryQueue.add(root);
        Node node;
        Queue<Node> temp;
        while(!primaryQueue.isEmpty() || !secondaryQueue.isEmpty()) {

            while(!primaryQueue.isEmpty()) {

                node = primaryQueue.remove();
                if(primaryQueue.isEmpty()) {
                    result.add(node.data);
                }
                if(node.left != null) {
                    secondaryQueue.add(node.left);
                }
                if(node.right != null) {
                    secondaryQueue.add(node.right);
                }
            }

            temp = primaryQueue;
            primaryQueue = secondaryQueue;
            secondaryQueue = temp;

        }
        return result;
    }

    public static void main(String[] args) {

        BinaryTreeRightSideView object = new BinaryTreeRightSideView();
        BinaryTree tree = object.new BinaryTree();
        tree.insert(20);
        tree.insert(10);
        tree.insert(30);
        tree.insert(7);
        tree.insert(15);
        tree.insert(25);


        List<Integer> result = object.rightSideView(tree.root);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
