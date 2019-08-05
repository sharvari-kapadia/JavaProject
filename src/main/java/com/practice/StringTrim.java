package com.practice;

/**
 * Created by SKapadia on 9/12/2016.
 */
public class StringTrim {

    public String trim(String s) {

        StringBuffer string = new StringBuffer(s);
        int length = string.length();

        int i = 0;
        while(i < length && string.charAt(i) == ' ') {
            i++;
        }
        int start = i;

        i = length - 1;
        while(i >= 0 && string.charAt(i) == ' ') {
            i--;
        }
        int end = i;

        if(end < start) {
            return "";
        }
        int newLength = end - start + 1;

        for(int j = 0, k = start; j < newLength; j++, k++) {
            string.setCharAt(j, string.charAt(k));
        }
        return string.substring(0, newLength);
    }

    public static void main(String[] args) {

        StringTrim object = new StringTrim();
        System.out.println("**" + object.trim("  ") + "**");
        System.out.println("**" + object.trim("  my name is sk.   ") + "**");
    }
}
