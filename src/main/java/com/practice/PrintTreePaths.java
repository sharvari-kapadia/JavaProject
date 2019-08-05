package com.practice;

import com.util.datastructures.BinarySearchTree;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by SKapadia on 10/6/2016.
 */
public class PrintTreePaths {

    public void print(BinarySearchTree.Node root) {
        _print(root, new ArrayList<>());
    }

    private void _print(BinarySearchTree.Node node, ArrayList<Integer> arrayList) {

        if(node.left == null && node.right == null) {
            arrayList.add(node.data);
            System.out.println(Arrays.toString(arrayList.toArray()));
            arrayList.remove(arrayList.size() - 1);
            return;
        }

        arrayList.add(node.data);
        if(node.left != null) {
            _print(node.left, arrayList);
        }
        if(node.right != null) {
            _print(node.right, arrayList);
        }
        arrayList.remove(arrayList.size() - 1);
    }

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(8);
        bst.insert(3);
        bst.insert(10);
        bst.insert(1);
        bst.insert(6);
        bst.insert(14);
        bst.insert(4);
        bst.insert(7);
        bst.insert(13);

        PrintTreePaths object = new PrintTreePaths();
        object.print(bst.root);
    }
}
