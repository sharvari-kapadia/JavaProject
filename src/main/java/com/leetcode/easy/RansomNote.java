package com.leetcode.easy;

import java.util.HashMap;

/**
 * Created by SKapadia on 10/26/2016.
 * https://leetcode.com/problems/ransom-note/
 *
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        int count;
        char c;
        for(int i = 0; i < magazine.length(); i++) {
            c = magazine.charAt(i);
            if(map.containsKey(c)) {
                count = map.get(c);
                count++;
            } else {
                count = 1;
            }
            map.put(c, count);
        }

        for(int i = 0; i < ransomNote.length(); i++){
            c = ransomNote.charAt(i);
            if(!map.containsKey(c)) {
                return false;
            }
            count = map.get(c);
            count--;
            if(count == 0) {
                map.remove(c);
            } else {
                map.put(c, count);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        RansomNote object = new RansomNote();
        assert !object.canConstruct("a", "b");
        assert !object.canConstruct("aa", "ab");
        assert object.canConstruct("aa", "aab");
        assert object.canConstruct("abb", "bxab");
    }
}
