/*
 * 11.30.2015
 * Given a sorted (increasing order) array with unique integer elements, write an algorithm to create a binary search
 * tree with minimal height.
 */

package com.practice.ctci.TreesAndGraphs;

import com.practice.ctci.datastructures.BinarySearchTree;

public class Q4_3 {

    int[] arr;
    Q4_3(int[] arr) {
        this.arr = arr;
    }

    public BinarySearchTree constructBSTWithMinimalHeight() {

        BinarySearchTree tree = new BinarySearchTree();
        _constructBSTWithMinimalHeight(tree, 0, arr.length-1);
        return tree;
    }

    private void _constructBSTWithMinimalHeight(BinarySearchTree tree, int low, int high) {

        if(high < low) {
            return;
        } else {
            int indexToInsert = (high+low)/2;
            tree.insert(arr[indexToInsert]);
            _constructBSTWithMinimalHeight(tree, low, indexToInsert-1);
            _constructBSTWithMinimalHeight(tree, indexToInsert+1, high);
        }
    }

    public static void main(String[] args) {

        int[] arr = new int[6];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        Q4_3 q4_3 = new Q4_3(arr);
        BinarySearchTree tree = q4_3.constructBSTWithMinimalHeight();
        tree.print();
    }
}
