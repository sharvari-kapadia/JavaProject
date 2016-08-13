package com.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by SKapadia on 6/27/2016.
 * https://leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger {

    public static int reverse(int x) {

        Queue<Integer> queue = new LinkedList<>();
        while(x != 0) {

            queue.add(x % 10);
            x = x / 10;
        }

        long newNum = 0;
        for(int i = queue.size() - 1; i >= 0; i--) {
            if(newNum > Integer.MAX_VALUE || newNum < Integer.MIN_VALUE) {
                return 0;
            }
            newNum += queue.remove() * Math.pow(10, i);
        }

        return (int)newNum;
    }

    public static void main(String[] args) {

        assert 0 == ReverseInteger.reverse(1534236469);
    }
}
