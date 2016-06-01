package com.practice.hackerrank;

/**
 * Created with IntelliJ IDEA.
 * User: SKapadia
 * Date: 5/30/16
 * Time: 11:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class Q2_1_JumpingJack {

    static int maxStep(int N, int K) {

        int returnValue = (N * (N + 1)) / 2;
        int sum = 0;
        for(int i = 1; i <= N; i++) {
            sum += i;
            if(sum == K) {
                return returnValue - 1;
            }
        }
        return returnValue;
    }
}
