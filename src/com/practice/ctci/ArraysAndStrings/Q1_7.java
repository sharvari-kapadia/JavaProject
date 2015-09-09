/*
  * 4.27.2015
  * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
  */

package com.practice.ctci.ArraysAndStrings;

import java.util.HashMap;
import java.util.Random;

public class Q1_7 {

    private int rows;
    private int cols;

    Q1_7(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    /**
     * Returns a pseudo-random number between min and max, inclusive.
     * The difference between min and max can be at most
     * <code>Integer.MAX_VALUE - 1</code>.
     *
     * @param min Minimum value
     * @param max Maximum value.  Must be greater than min.
     * @return Integer between min and max, inclusive.
     * @see java.util.Random#nextInt(int)
     */
    private static int randInt(int min, int max) {

        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    public void printMatrix(int[][] matrix) {

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Generates matrix with random values between [0, 4]
    public int[][] generateMatrix() {

        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = randInt(0, 4);
            }
        }
        return matrix;
    }

    // Adds row and column position of elements with 0 value to zeroRows and zeroCols respectively
    private void getZeroPositions(int[][] matrix, HashMap<Integer, Boolean> zeroRows, HashMap<Integer, Boolean> zeroCols) {

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows.put(i, true);
                    zeroCols.put(j, true);
                }
            }
        }
    }

    // Set row and column 0 of elements with value 0
    public int[][] updateMatrix(int[][] matrix) {

        HashMap<Integer, Boolean> zeroRows = new HashMap<Integer, Boolean>();
        HashMap<Integer, Boolean> zeroCols = new HashMap<Integer, Boolean>();
        getZeroPositions(matrix, zeroRows, zeroCols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] != 0) {
                    if (zeroRows.containsKey(i) || zeroCols.containsKey(j)) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        return matrix;
    }

    public static void main(String[] args) {

        Q1_7 q = new Q1_7(4, 4);
        int[][] matrix = q.generateMatrix();
        System.out.println("Original matrix: ");
        q.printMatrix(matrix);
        System.out.println("Updated matrix: ");
        q.printMatrix(q.updateMatrix(matrix));
    }
}
