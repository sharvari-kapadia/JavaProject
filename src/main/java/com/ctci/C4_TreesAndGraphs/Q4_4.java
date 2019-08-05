/*
 * 6.6.2016
 * Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth (e.g., if you
 * have a tree with depth D, you'll have D linked lists).
 */

package com.ctci.C4_TreesAndGraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q4_4 {

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

    public enum Direction {
        LEFT, RIGHT
    }

    public class BinaryTree {

        Node root;
        Direction lastDirection;

        BinaryTree() {
            root = null;
            lastDirection = Direction.LEFT;
        }

        Direction getDirection() {

            if(lastDirection.equals(Direction.LEFT)) {
                lastDirection = Direction.RIGHT;
            } else {
                lastDirection = Direction.LEFT;
            }

            return lastDirection;
        }

        Node getRoot() {
            return root;
        }

        void insert(int data) {

            Node node = new Q4_4.Node(data);

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
                    if (getDirection().equals(Direction.LEFT)) {
                        current = current.left;
                    } else {
                        current = current.right;
                    }
                }
            }
        }
    }

    public Node createTree(ArrayList<Integer> dataList) {

        BinaryTree tree = new BinaryTree();
        for(int i : dataList) {
            tree.insert(i);
        }
        return tree.getRoot();
    }

    public ArrayList<LinkedList<Node>> createLinkedLists(Node root) {

        class NodeAndLevel {

            Node node;
            int level;

            NodeAndLevel(Node node, int level) {
                this.node = node;
                this.level = level;
            }
        }

        ArrayList<LinkedList<Node>> arrayList = new ArrayList<>();
        arrayList.add(new LinkedList<>());

        Queue<NodeAndLevel> queue = new LinkedList<>();
        int level = 0;
        queue.add(new NodeAndLevel(root, level));

        NodeAndLevel currentNodeAndLevel;
        Node currentNode;
        int currentLevel;

        while(!queue.isEmpty()) {

            currentNodeAndLevel = queue.remove();
            currentNode = currentNodeAndLevel.node;
            currentLevel = currentNodeAndLevel.level;

            if(currentLevel != level) {
                level++;
                arrayList.add(new LinkedList<>());
            }
            arrayList.get(level).add(currentNode);

            if(currentNode.left != null) {
                queue.add(new NodeAndLevel(currentNode.left, level + 1));
            }

            if(currentNode.right != null) {
                queue.add(new NodeAndLevel(currentNode.right, level + 1));
            }
        }

        return arrayList;
    }

    public void printArrayList(ArrayList<LinkedList<Node>> arrayList) {

        for(LinkedList<Node> linkedList : arrayList) {
            for(Node node : linkedList) {
                System.out.print(node.data + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Q4_4 q4_4 = new Q4_4();
        ArrayList<LinkedList<Node>> arrayList = q4_4.createLinkedLists(q4_4.createTree(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7))));

        q4_4.printArrayList(arrayList);
    }
}
