package com.leetcode.easy;

/**
 * Created by skapadia on 6/16/2016.
 * https://leetcode.com/problems/reverse-string/
 */
public class ReverseString {

    public String reverseString(String s) {

        StringBuffer sb = new StringBuffer(s);
        int length = sb.length();
        for(int i = 0; i < sb.length()/2; i++) {
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(length - i - 1));
            sb.setCharAt(length - i - 1, temp);
        }
        return new String(sb);
    }

    public static void main(String[] args) {

        ReverseString reverseString = new ReverseString();
        System.out.println(reverseString.reverseString("sharvari"));
    }
}
