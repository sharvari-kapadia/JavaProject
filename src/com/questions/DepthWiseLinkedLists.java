/*
 * 6.8.2016
 * Given a binary tree, design an algorithm which creates a linked list of all the nodes in each path
 */

package com.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class DepthWiseLinkedLists {

    private class Node {

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

    private class BinaryTree {

        private Node root;
        private Direction lastDirection;

        private BinaryTree() {
            root = null;
            lastDirection = Direction.LEFT;
        }

        private Direction getDirection() {
            if(lastDirection.equals(Direction.LEFT)) {
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
    }

    public Node createBinaryTree(ArrayList<Integer> dataList) {
        BinaryTree tree = new BinaryTree();
        for(int i : dataList) {
            tree.insert(i);
        }
        return tree.getRoot();
    }

    public ArrayList<LinkedList<Node>> getLinkedLists(Node root) {

        ArrayList<LinkedList<Node>> arrayList = new ArrayList<>();
        if(root == null) {
            return arrayList;
        }

        LinkedList<Node> linkedList = new LinkedList<>();
        linkedList.add(root);
        _getLinkedLists(root, arrayList, linkedList);
        return arrayList;
    }

    private void _getLinkedLists(Node node, ArrayList<LinkedList<Node>> arrayList, LinkedList<Node> linkedList) {

        if(node.left == null && node.right == null) {
            arrayList.add(new LinkedList<>(linkedList));
            return;
        }

        if(node.left != null) {
            linkedList.addLast(node.left);
            _getLinkedLists(node.left, arrayList, linkedList);
            linkedList.removeLast();
        }

        if(node.right != null) {
            linkedList.addLast(node.right);
            _getLinkedLists(node.right, arrayList, linkedList);
            linkedList.removeLast();
        }
    }

    public void print(ArrayList<LinkedList<Node>> arrayList) {

        for(LinkedList<Node> linkedList : arrayList) {
            for(Node node : linkedList) {
                System.out.print(node.data + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        DepthWiseLinkedLists depthWiseLinkedLists = new DepthWiseLinkedLists();
        Node root = depthWiseLinkedLists.createBinaryTree(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
        ArrayList<LinkedList<Node>> arrayList = depthWiseLinkedLists.getLinkedLists(root);
        depthWiseLinkedLists.print(arrayList);
    }
}

