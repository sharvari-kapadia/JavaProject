package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SKapadia on 10/17/2016.
 * https://leetcode.com/problems/permutations/
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        ArrayList<Integer> selected = new ArrayList<>();
        ArrayList<Integer> selectFrom = new ArrayList<>(nums.length);
        for(int i = 0; i < nums.length; i++) {
            selectFrom.add(nums[i]);
        }
        _permute(selected, selectFrom, resultList);
        return resultList;
    }

    private void _permute(ArrayList<Integer> selected, ArrayList<Integer> selectFrom, List<List<Integer>> resultList) {
        if(selectFrom.size() == 0) {
            resultList.add(new ArrayList<>(selected));
            return;
        }

        for(int i = 0; i < selectFrom.size(); i++) {
            int curr = selectFrom.remove(i);
            selected.add(curr);
            _permute(selected, selectFrom, resultList);
            selected.remove(selected.size() - 1);
            selectFrom.add(i, curr);
        }
    }

    public static void main(String[] args) {
        Permutations object = new Permutations();
        System.out.println(object.permute(new int[]{1, 2, 3}).toString());
    }
}
