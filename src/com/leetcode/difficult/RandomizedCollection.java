package com.leetcode.difficult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/**
 * Created by SKapadia on 8/27/2016.
 * https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
 */
public class RandomizedCollection {

    private HashMap<Integer, HashSet<Integer>> myMap;
    private ArrayList<Integer> myArray;
    private Random rand;

    /** Initialize your data structure here. */
    public RandomizedCollection() {

        myMap = new HashMap<>();
        myArray = new ArrayList<>();
        rand = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {

        int index = myArray.size();
        myArray.add(val);
        HashSet<Integer> indexSet;
        boolean returnValue = false;

        if(myMap.containsKey(val)) {
            indexSet = myMap.get(val);
        } else {
            returnValue = true;
            indexSet = new HashSet<>();
        }
        indexSet.add(index);
        myMap.put(val, indexSet);
        return returnValue;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {

        if(myMap.containsKey(val)) {

            // remove index of item to be removed from map
            HashSet<Integer> indexSet = myMap.get(val);
            int indexOfRemovedItem = indexSet.iterator().next();
            indexSet.remove(indexOfRemovedItem);
            if(indexSet.size() == 0) {
                myMap.remove(val);
            } else {
                myMap.put(val, indexSet);
            }

            int oldIndexOfLastArrayItem = myArray.size() - 1;
            int lastArrayItem = myArray.remove(oldIndexOfLastArrayItem);
            if(oldIndexOfLastArrayItem != indexOfRemovedItem) {

                // move lastArrayItem in place of the removed item
                if (indexOfRemovedItem < myArray.size()) {
                    myArray.set(indexOfRemovedItem, lastArrayItem);
                }

                // update index of lastArrayItem in map
                indexSet = myMap.get(lastArrayItem);
                indexSet.remove(oldIndexOfLastArrayItem);
                indexSet.add(indexOfRemovedItem);
                myMap.put(lastArrayItem, indexSet);
            }

            return true;
        }
        return false;
    }

    /** Get a random element from the collection. */
    public int getRandom() {

        return myArray.get(rand.nextInt(myArray.size()));
    }

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
    public static void main(String[] args) {

        RandomizedCollection obj = new RandomizedCollection();
        assert obj.insert(1);
        assert !obj.insert(1);
        assert obj.remove(1);
        assert obj.insert(2);
        System.out.println(obj.getRandom());
        assert obj.remove(2);
        System.out.println(obj.getRandom());
    }
}