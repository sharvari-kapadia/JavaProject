package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by SKapadia on 9/15/2016.
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class PreOrderTraversalOfTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> preOrderTraversal(TreeNode root) {

        List<Integer> resultList = new ArrayList<>();
        if(root == null) {
            return resultList;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode node;

        while(!stack.isEmpty()) {

            node = stack.pop();
            resultList.add(node.val);
            if(node.right != null) {
                stack.add(node.right);
            }
            if(node.left != null) {
                stack.add(node.left);
            }
        }

        return resultList;
    }

    public List<Integer> preOrderTraversal2(TreeNode root) {

        List<Integer> resultList = new ArrayList<>();
        return _preOrderTraversal(root, resultList);
    }

    private List<Integer> _preOrderTraversal(TreeNode root, List<Integer> resultList) {

        if(root == null) {
            return resultList;
        }

        resultList.add(root.val);
        _preOrderTraversal(root.left, resultList);
        _preOrderTraversal(root.right, resultList);

        return resultList;
    }
}
