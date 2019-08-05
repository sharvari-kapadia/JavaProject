package com.leetcode.easy;

/**
 * Created by skapadia on 6/16/2016.
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 */
public class ReverseVowels {
    public String reverseVowels(String s) {

        StringBuffer sb = new StringBuffer(s);
        int length = sb.length();
        int i = 0;
        int j = length - 1;
        while(i < length && j < length && i < j) {

            while(i < length && !isVowel(sb.charAt(i))) {
                i++;
            }

            while(j >= 0 && !isVowel(sb.charAt(j))) {
                j--;
            }

            if(i < j) {
                char temp = sb.charAt(i);
                sb.setCharAt(i, sb.charAt(j));
                sb.setCharAt(j, temp);
                i++;
                j--;
            }
        }
        return new String(sb);
    }

    private boolean isVowel(char character) {

        char c = Character.toLowerCase(character);
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        ReverseVowels reverseVowels = new ReverseVowels();
        System.out.println(reverseVowels.reverseVowels(".,"));
    }
}
