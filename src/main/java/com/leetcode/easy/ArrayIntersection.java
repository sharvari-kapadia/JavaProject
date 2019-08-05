package com.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by SKapadia on 7/20/2016.
 * https://leetcode.com/problems/intersection-of-two-arrays/
 */
public class ArrayIntersection {

    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> hashSet1 = new HashSet<>();
        HashSet<Integer> hashSet2 = new HashSet<>();
        for(Integer num : nums1) {
            hashSet1.add(num);
        }

        for(Integer num : nums2) {
            if(hashSet1.contains(num)) {
                hashSet2.add(num);
            }
        }

        int resultSize = hashSet2.size();
        int[] resultArray = new int[resultSize];
        int i = 0;
        for(int num : hashSet2) {
            resultArray[i] = num;
            i++;
        }
        return resultArray;
    }

    public static void main(String[] args) {
        int[] resultArray = new ArrayIntersection().intersection(new int[]{1}, new int[]{1, 1});
        System.out.println(Arrays.toString(resultArray));
    }
}
