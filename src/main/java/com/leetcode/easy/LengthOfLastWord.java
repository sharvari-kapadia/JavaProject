package com.leetcode.easy;

/**
 * Created by skapadia on 10/12/2016.
 * https://leetcode.com/problems/length-of-last-word/
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {

        s = s.trim();
        int count = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            if(i < 0 || s.charAt(i) == ' ') {
                break;
            }
            count++;
        }
        return count;
    }
}
