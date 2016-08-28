package com.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by SKapadia on 8/27/2016.
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 */
public class ArrayIntersection2 {

    public int[] intersection(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> hashMap1 = new HashMap<>();
        int count;

        for(Integer num : nums1) {
            if(hashMap1.containsKey(num)) {
                count = hashMap1.get(num);
                count++;
            } else {
                count = 1;
            }
            hashMap1.put(num, count);
        }

        ArrayList<Integer> resultList = new ArrayList<>();
        for(Integer num : nums2) {
            if(hashMap1.containsKey(num)) {
                count = hashMap1.get(num);
                count--;
                if(count == 0) {
                    hashMap1.remove(num);
                } else {
                    hashMap1.put(num, count);
                }
                resultList.add(num);
            }
        }

        return resultList.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        int[] resultArray = new ArrayIntersection2().intersection(new int[]{1}, new int[]{1, 1});
        System.out.println(Arrays.toString(resultArray));
    }
}
