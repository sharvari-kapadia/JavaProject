package com.leetcode.easy;

/**
 * Created by SKapadia on 9/27/2016.
 * https://leetcode.com/problems/find-the-difference/
 */
public class FindTheDifference {

    public char findTheDifference(String s, String t) {
        int sum = 0;
        for(int i = 0; i < t.length(); i++) {
            sum += t.charAt(i);
        }

        for(int i = 0; i < s.length(); i++) {
            sum -= s.charAt(i);
        }

        return (char)sum;
    }

    public static void main(String[] args) {
        FindTheDifference object = new FindTheDifference();
        object.findTheDifference("abcd", "abcde");
    }
}
