package com.questions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by SKapadia on 9/1/2016.
 */
public class MirrorTree {

    public class Node<T> {

        T data;
        Node left;
        Node right;
        Node(T data) {

            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public void mirrorTree1(Node root) {

        if(root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node node;
        Node temp;

        while(!queue.isEmpty()) {
            node = queue.remove();
            temp = node.left;
            node.left = node.right;
            node.right = temp;
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public void mirrorTree2(Node root) {

        if(root == null) {
            return;
        }

        _mirrorTree2(root);
    }

    private void _mirrorTree2(Node node) {

        if(node == null) {
            return;
        }

        Node temp;
        temp = node.left;
        node.left = node.right;
        node.right = temp;
        _mirrorTree2(node.left);
        _mirrorTree2(node.right);
    }
}
