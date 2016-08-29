package com.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by SKapadia on 8/28/2016.
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        int length = nums.length;
        HashMap<Integer, ArrayList<Integer>> indexesMap = new HashMap<>();
        ArrayList<Integer> indexesList;
        int currVal;

        for(int i = 0; i < length; i++) {
            currVal = nums[i];
            if(indexesMap.containsKey(currVal)) {
                indexesList = indexesMap.get(currVal);
            } else {
                indexesList = new ArrayList<>();
            }
            indexesList.add(i);
            indexesMap.put(nums[i], indexesList);
        }
        Arrays.sort(nums);

        int firstNum = 0;
        int secondNum = 0;

        for(int i = 0; i < length; i++) {

            firstNum = nums[i];
            secondNum = target - firstNum;
            if(search(nums, i+1, length-1, secondNum)) {
               break;
            }
        }

        ArrayList<Integer> index1 = indexesMap.get(firstNum);
        int ind1 = index1.remove(0);
        indexesMap.put(firstNum, index1);

        ArrayList<Integer> index2 = indexesMap.get(secondNum);
        int ind2 = index2.remove(0);
        indexesMap.put(secondNum, index2);

        return new int[]{ind1, ind2};
    }

    private boolean search(int[] nums, int low, int high, int searchItem) {

        if(low <= high) {
            int mid = low + (high - low) / 2;
            int currMidVal = nums[mid];
            if (searchItem < currMidVal) {
                return search(nums, low, mid - 1, searchItem);
            } else if (searchItem > currMidVal) {
                return search(nums, mid + 1, high, searchItem);
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        TwoSum object = new TwoSum();

        int[] result1 = object.twoSum(new int[]{2, 7, 11, 15, 8, 3}, 9);
        assert (result1[0] == 0 && result1[1] == 1) || (result1[0] == 1 && result1[1] == 0);

        int[] result2 = object.twoSum(new int[]{2, 7, 11, 15, 8, 3}, 26);
        assert (result2[0] == 2 && result2[1] == 3) || (result2[0] == 3 && result2[1] == 2);

        int[] result3 = object.twoSum(new int[]{0, 4, 3, 0}, 0);
        assert (result3[0] == 0 && result3[1] == 3) || (result3[0] == 3 && result3[1] == 0);
    }
}
