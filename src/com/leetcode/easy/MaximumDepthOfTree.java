package com.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by SKapadia on 6/26/2016.
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class MaximumDepthOfTree {

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

    MaximumDepthOfTree() {
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

    public int maxDepth(Node root) {

        if(root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {

        ArrayList<Integer> dataList = new ArrayList(Arrays.asList());
        MaximumDepthOfTree object = new MaximumDepthOfTree();
        Node root = object.createBinaryTree(dataList);
        System.out.println(object.maxDepth(root));
    }
}
