package com.leetcode.easy;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Created by SKapadia on 10/14/2016.
 * https://leetcode.com/problems/third-maximum-number/
 */
public class ThirdMaximum {
    public int thirdMax(int[] nums) {
        if(nums.length < 3) {
            int max = 0;
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] > max) {
                    max = nums[i];
                }
            }
            return max;
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();
        HashSet<Integer> set = new HashSet<>();
        int curr;
        int itemRemoved;
        for(int i = 0; i < nums.length; i++) {
            curr = nums[i];
            if(i < 3) {
                q.add(curr);
                set.add(curr);
            } else if(q.peek() < curr && !set.contains(curr)) {
                itemRemoved = q.remove();
                set.remove(itemRemoved);
                q.add(curr);
                set.add(curr);
            }
        }
        return q.peek();
    }

    public static void main(String[] args) {
        ThirdMaximum object = new ThirdMaximum();
        assert 6 == object.thirdMax(new int[]{4,5,7,8,2,3,6});
        assert 2 == object.thirdMax(new int[]{1,2,3,4,0,-1,3});
    }
}
