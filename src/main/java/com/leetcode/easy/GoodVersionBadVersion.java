package com.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by SKapadia on 8/13/2016.
 * https://leetcode.com/problems/first-bad-version/
 */
public class GoodVersionBadVersion {

    ArrayList<String> input;
    GoodVersionBadVersion(ArrayList<String> input) {

        this.input = input;
    }

    public int firstBadVersion(int n) {

        int low = 1;
        int high = n;
        int lastBadVersion = 0;
        int mid;

        while(low <= high) {

            mid = low + (high - low)/2;
            if(isBadVersion(mid)) {
                lastBadVersion = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return lastBadVersion;
    }

    private boolean isBadVersion(int k) {

        return input.get(k).equals("b");
    }

    public static void main(String[] args) {

        ArrayList<String> input1 = new ArrayList<>(Arrays.asList("", "g", "g", "g", "b", "b", "b", "b", "b", "b", "b"));
        GoodVersionBadVersion object1 = new GoodVersionBadVersion(input1);
        assert 4 == object1.firstBadVersion(input1.size() - 1);

        ArrayList<String> input2 = new ArrayList<>(Arrays.asList("", "g", "g", "g", "g", "g", "g", "g", "b", "b", "b"));
        GoodVersionBadVersion object2 = new GoodVersionBadVersion(input2);
        assert 8 == object2.firstBadVersion(input2.size() - 1);

        ArrayList<String> input3 = new ArrayList<>(Arrays.asList("", "g", "g", "b", "b", "b", "b", "b", "b", "b", "b"));
        GoodVersionBadVersion object3 = new GoodVersionBadVersion(input3);
        assert 3 == object3.firstBadVersion(input3.size() - 1);

        ArrayList<String> input4 = new ArrayList<>(Arrays.asList("", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b"));
        GoodVersionBadVersion object4 = new GoodVersionBadVersion(input4);
        assert 1 == object4.firstBadVersion(input4.size() - 1);

        ArrayList<String> input5 = new ArrayList<>(Arrays.asList("", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g"));
        GoodVersionBadVersion object5 = new GoodVersionBadVersion(input5);
        assert 0 == object5.firstBadVersion(input5.size() - 1);

        ArrayList<String> input6 = new ArrayList<>(Arrays.asList(""));
        GoodVersionBadVersion object6 = new GoodVersionBadVersion(input6);
        assert 0 == object6.firstBadVersion(input6.size() - 1);
    }
}
