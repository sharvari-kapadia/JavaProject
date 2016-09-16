package com.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by SKapadia on 8/6/2016.
 * https://leetcode.com/problems/insert-delete-getrandom-o1/
 */
public class RandomizedSet {

    private HashMap<Integer, Integer> myMap;
    private ArrayList<Integer> myArray;
    private Random rand;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        myMap = new HashMap<>();
        myArray = new ArrayList<>();
        rand = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {

        if(!myMap.containsKey(val)) {
            myArray.add(val);
            int index = myArray.size() - 1;
            myMap.put(val, index);
            return true;
        }
        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {

        if(myMap.containsKey(val)) {
            int indexOfItemToBeRemoved = myMap.remove(val);
            int lastItem = myArray.remove(myArray.size() - 1);
            if(indexOfItemToBeRemoved < myArray.size()) {
                myArray.set(indexOfItemToBeRemoved, lastItem);
            }
            if(myMap.containsKey(lastItem)) {
                myMap.put(lastItem, indexOfItemToBeRemoved);
            }
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {

        return myArray.get(rand.nextInt(myArray.size()));
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

    public static void main(String[] args) {

        RandomizedSet obj = new RandomizedSet();
        assert obj.insert(3);
        assert !obj.insert(3);
        assert obj.insert(1);
        assert obj.remove(3);
        assert obj.insert(0);
        assert obj.remove(0);
        System.out.println(obj.getRandom());
    }
}
