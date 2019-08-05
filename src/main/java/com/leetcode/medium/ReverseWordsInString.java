package com.leetcode.medium;

/**
 * Created by SKapadia on 9/9/2016.
 * https://leetcode.com/problems/reverse-words-in-a-string/
 */
public class ReverseWordsInString {

    public String reverseWords(String s) {

        StringBuffer newString = removeMultipleSpacesAndTrim(s);
        StringBuffer reversedString = reverse(newString, 0, newString.length());

        int i = 0;
        int start;
        while(i < reversedString.length()) {

            start = i;
            while(i < reversedString.length() && reversedString.charAt(i) != ' ') {
                i++;
            }
            reversedString = reverse(reversedString, start, i);
            while(i < reversedString.length() && reversedString.charAt(i) == ' ') {
                i++;
            }
        }
        return new String(reversedString);
    }

    private StringBuffer reverse(StringBuffer string, int start, int end) {

        char temp;
        while(start < end-1) {

            temp = string.charAt(start);
            string.setCharAt(start, string.charAt(end-1));
            string.setCharAt(end-1, temp);
            start++;
            end--;
        }
        return string;
    }

    private StringBuffer removeMultipleSpacesAndTrim(String string) {

        StringBuffer str = new StringBuffer(string.trim());
        int i = 0;
        int j = 0;
        int length = str.length();
        while(i < length) {

            // non space characters
            while(i < length && str.charAt(i) != ' ') {
                str.setCharAt(j, str.charAt(i));
                i++;
                j++;
            }

            // first space character
            if(i < length) {
                str.setCharAt(j, str.charAt(i));
                i++;
                j++;
            }

            // other space characters
            while(i < length && str.charAt(i) == ' ') {
                str.setCharAt(j, str.charAt(i));
                i++;
            }
        }

        return new StringBuffer(str.substring(0, j));
    }

    public static void main(String[] args) {

        ReverseWordsInString object = new ReverseWordsInString();
        System.out.println("**" + object.reverseWords("   My  name is Sharvari  ") + "**");
        System.out.println("**" + object.reverseWords("  ") + "**");
        System.out.println("**" + object.reverseWords("") + "**");
        System.out.println("**" + object.reverseWords("  MY") + "**");

    }
}
