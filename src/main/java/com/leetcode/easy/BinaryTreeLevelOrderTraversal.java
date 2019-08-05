package com.leetcode.easy;

import java.util.*;

/**
 * Created by SKapadia on 8/23/2016.
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeLevelOrderTraversal {

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


    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        Queue<Node> primaryQueue = new LinkedList<>();
        Queue<Node> secondaryQueue = new LinkedList<>();

        primaryQueue.add(root);
        Node node;
        Queue<Node> temp;
        while(!primaryQueue.isEmpty() || !secondaryQueue.isEmpty()) {

            List<Integer> list;
            result.add(new ArrayList<>());
            while(!primaryQueue.isEmpty()) {

                node = primaryQueue.remove();
                list = result.get(result.size() - 1);
                list.add(node.data);
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

        BinaryTreeLevelOrderTraversal object = new BinaryTreeLevelOrderTraversal();
        BinaryTree tree = object.new BinaryTree();
        tree.insert(20);
        tree.insert(10);
        tree.insert(30);
        tree.insert(15);
        tree.insert(25);
        tree.insert(35);

        List<List<Integer>> result = object.levelOrder(tree.root);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
