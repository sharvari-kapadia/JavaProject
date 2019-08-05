package com.practice;

/**
 * Created by skapadia on 9/28/2016.
 */
public class SubString {

    public boolean isSubString(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();

        if(length2 > length1) {
            return false;
        }

        int i = 0;
        int j = 0;
        while(i < length1) {
            if(s1.charAt(i) == s2.charAt(j)) {
                if(i > (length1 - length2)) {
                    return false;
                } else if(isSubString(s1, s2, i)) {
                    return true;
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }
        return false;
    }

    private boolean isSubString(String s1, String s2, int s1StartingIndex) {

        int i = s1StartingIndex;
        int j = 0;

        while(i < s1.length() && j < s2.length()) {
            if(s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        SubString object = new SubString();
        assert object.isSubString("sharvari", "harv");
        assert object.isSubString("sharvari", "ari");
        assert !object.isSubString("sharvari", "arii");
        assert !object.isSubString("sharvari", "sharu");
    }
}
