package com.leetcode.easy;

import java.util.HashMap;

/**
 * Created by skapadia on 8/25/2016.
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 */
public class FirstUniqueCharacter {

    public int firstUniqChar(String s) {

        HashMap<Character, Integer[]> characterHashMap = new HashMap<>();
        Character c;
        Integer[] value; // [index, count]
        for(int index = 0; index < s.length(); index++) {

            c = s.charAt(index);

            if(characterHashMap.containsKey(c)) {
                value = characterHashMap.get(c);
                value[1] += 1;
            } else {
                value = new Integer[]{index, 1};
            }
            characterHashMap.put(c, value);
        }

        int minIndex = -1;
        for(Integer[] values: characterHashMap.values()) {

            if(values[1] == 1) {
                if(minIndex == -1 || values[0] < minIndex) {
                    minIndex = values[0];
                }
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {

        FirstUniqueCharacter object = new FirstUniqueCharacter();
        assert 0 == object.firstUniqChar("leetcode");
        assert 2 == object.firstUniqChar("loveleetcode");
        assert -1 == object.firstUniqChar("");
    }
}
