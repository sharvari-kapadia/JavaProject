package com.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by SKapadia on 9/15/2016.
 * https://leetcode.com/problems/symmetric-tree/
 */
public class SymmetricTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isSameTree(invertTree(root.left), root.right);
    }

    private TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode node;
        TreeNode temp;

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
        return root;
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }

        if((p == null && q != null) || (q == null && p != null)) {
            return false;
        }

        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
