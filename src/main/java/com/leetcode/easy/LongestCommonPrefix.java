package com.leetcode.easy;

import java.util.Arrays;

/**
 * Created by skapadia on 10/7/2016.
 * https://leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        if(strs.length == 0) {
            return "";
        }
        Arrays.sort(strs);
        StringBuilder sb = new StringBuilder(strs[0]);
        for(int i = 1; i < strs.length; i++) {
            String currentString = strs[i];
            int length = Math.min(currentString.length(), sb.length());
            for(int j = 0; j < length; j++) {
                if(currentString.charAt(j) != sb.charAt(j)) {
                    sb.delete(j, sb.length());
                    length =  Math.min(currentString.length(), sb.length());
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        LongestCommonPrefix object = new LongestCommonPrefix();
        assert "a".equals(object.longestCommonPrefix(new String[]{"aa", "a"}));
    }
}
