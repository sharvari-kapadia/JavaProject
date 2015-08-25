package com.mindsmapped.hw1;

public class Q1 {
    private static double[] squareRoots;

    static {
        System.out.println("In a static block!");
        for (int i = 0; i < squareRoots.length; i++) { // Null Pointer Exception
            squareRoots[i] = Math.sqrt((double) i);
        }
    }

    Q1() {
        squareRoots = new double[100];
        System.out.println("In constructor!");
        System.out.println(squareRoots.length);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Q1 obj = new Q1();
    }
}

/*
 * Null pointer exception because squareRoots is null and we are accessing
 * null.something
 */

