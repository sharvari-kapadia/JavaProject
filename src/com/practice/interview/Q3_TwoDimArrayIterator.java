package com.practice.interview;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by SKapadia on 4/26/2016.
 *
 * boolean hasNext()
 * returns true or false if there is another element in the set
 *
 * int next()
 * returns the value of the next element in the array
 *
 * void remove()
 * removes the last element returned by the iterator.  That is, remove the element that the previous next() returned
 *
 * Given:  [[],[1,2,3],[4,5],[],[],[6],[7,8],[],[9],[10],[11, 12, 13]]
 * Print:  1 2 3 4 5 6 7 8 9 10
 */

class Q3_TwoDimArrayIterator {

    private ArrayList<ArrayList<Integer>> input;
    private int innerIndex;
    private int outerIndex;

    Q3_TwoDimArrayIterator(ArrayList<ArrayList<Integer>> input) {
        this.input = input;
        this.innerIndex = 0;
        this.outerIndex = 0;
    }

    private int getSize() {
        return input.size();
    }

    private boolean areIndexesValid() {
        return areIndexesValid(innerIndex, outerIndex);
    }

    private boolean areIndexesValid(int inner, int outer) {

        if(inner == -1 && outer == -1) {
            return false;
        }

        ArrayList<Integer> tempArray;

        if(outer <= getSize() - 1) {
            tempArray = input.get(outer);
            if(inner <= tempArray.size() - 1) {
                return true;
            }
        }
        return false;
    }
    /*
    * returns true if it was able to successful in incrementing the inner and outer indexes
    * returns false if the outer index reaches the end of array
    * */
    private boolean incrementIndexes() {

        if(outerIndex <= getSize() - 1) {
            ArrayList<Integer> tempArray = input.get(outerIndex);
            innerIndex++;
            if(innerIndex <= tempArray.size() - 1) {

            } else {
                innerIndex = 0;
                outerIndex++;
            }
            return true;
        }
        return false;
    }

    private ArrayList<Integer> decrementIndexes(int tempInner, int tempOuter) {

        tempInner--;
        if(tempInner == -1) {
            tempOuter--;
            if(tempOuter == -1) {
                return new ArrayList<>(Arrays.asList(-1, -1));
            } else {
                tempInner = input.get(tempOuter).size() - 1;
            }
        }
        return new ArrayList<>(Arrays.asList(tempInner, tempOuter));
    }

    public boolean hasNext() {

        if(areIndexesValid()) {
            return true;
        }
        return false;
    }

    public int next() {

        while (!areIndexesValid()) {
            if (!incrementIndexes()) {
                break;
            }
        }

        if(areIndexesValid()) {
            int returnValue = input.get(outerIndex).get(innerIndex);
            do {
                if (!incrementIndexes()) {
                    break;
                }
            } while (!areIndexesValid());

            return returnValue;
        }
        return -1;
    }

    public boolean remove() {
        int tempInner = innerIndex;
        int tempOuter = outerIndex;

        ArrayList<Integer> decrementedIndexes;
        do {
            decrementedIndexes = decrementIndexes(tempInner, tempOuter);
            tempInner = decrementedIndexes.get(0);
            tempOuter = decrementedIndexes.get(1);
        } while (!areIndexesValid(tempInner, tempOuter));

        if(areIndexesValid(tempInner, tempOuter)) {
            ArrayList<Integer> tempArray = input.get(tempOuter);
            tempArray.remove(tempInner);
            return true;
        }
        return false;
    }

    public void printArray() {
        System.out.println(input.toString());
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>(Arrays.asList(
                new ArrayList<Integer>(),
                new ArrayList<Integer>(Arrays.asList(1, 2, 3)),
                new ArrayList<Integer>(Arrays.asList(4, 5)),
                new ArrayList<Integer>()));

        Q3_TwoDimArrayIterator twoDimArrayIterator = new Q3_TwoDimArrayIterator(input);
        twoDimArrayIterator.printArray();

        System.out.println(twoDimArrayIterator.next());
        twoDimArrayIterator.remove();

        twoDimArrayIterator.printArray();
    }
}

