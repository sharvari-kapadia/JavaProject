package com.practice.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by SKapadia on 3/23/2016.
 */
public class QuickSort {

    public static ArrayList<Integer> sort(ArrayList<Integer> arrayToSort) {
        int arrayLength = arrayToSort.size();

        // Base condition
        if(arrayLength < 2) {
            return arrayToSort;
        }

        int pivot = arrayToSort.get(arrayLength-1);
        int currentItem;
        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();

        for(int i = 0; i < arrayLength-1; i++) {
            currentItem = arrayToSort.get(i);
            if(currentItem <= pivot) {
                left.add(currentItem);
            } else {
                right.add(currentItem);
            }
        }

        ArrayList<Integer> sortedArray = new ArrayList<>();
        sortedArray.addAll(sort(left));
        sortedArray.add(pivot);
        sortedArray.addAll(sort(right));

        return sortedArray;
    }

    public static void main(String[] args) {
        List arrayToSort = Arrays.asList(6, 3, 5, 7, 9, 2, 1);
        ArrayList<Integer> array = new ArrayList<Integer>(arrayToSort);
        System.out.println(arrayToSort.toString());
        System.out.println(QuickSort.sort(array).toString());
    }
}
