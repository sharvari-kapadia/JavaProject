package com.leetcode.easy;

import java.util.HashMap;

/**
 * Created by SKapadia on 7/9/2016.
 * https://leetcode.com/problems/valid-anagram/
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> charCountMap = new HashMap<>();
        Character currChar;
        int currCount;
        for(int i = 0; i < s.length(); i++) {

            currChar = s.charAt(i);
            if(charCountMap.containsKey(currChar)) {
                currCount = charCountMap.get(currChar) + 1;
            } else {
                currCount = 1;
            }
            charCountMap.put(currChar, currCount);
        }

        for(int i = 0; i < t.length(); i++) {

            currChar = t.charAt(i);
            if(!charCountMap.containsKey(currChar)) {
                return false;
            } else {
                currCount = charCountMap.get(currChar) - 1;
                if(currCount == 0) {
                    charCountMap.remove(currChar);
                } else {
                    charCountMap.put(currChar, currCount);
                }
            }
        }

        return charCountMap.isEmpty();
    }

    public static void main(String[] args) {

        assert new ValidAnagram().isAnagram("anagram", "nagaram");
        assert !new ValidAnagram().isAnagram("rat", "cat");
        assert new ValidAnagram().isAnagram("", "");
        assert !new ValidAnagram().isAnagram("aaa", "aa");
    }
}
