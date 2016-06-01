package com.practice.hackerrank;

import java.util.*;

public class Q1_3_SpiralMatrix {

    HashMap<Integer, Boolean> row;
    HashMap<Integer, Boolean> col;
    int[][] array;
    int m;
    int n;
    boolean firstTime;

    Q1_3_SpiralMatrix(int[][] array, int m, int n) {
        this.array = array;
        this.m = m;
        this.n = n;
        row = new HashMap<Integer, Boolean>();
        col = new HashMap<Integer, Boolean>();
        firstTime = true;
    }

    private void printItemIfValid(int i, int j) {

        if(!row.containsKey(i) && !col.containsKey(j)) {
            if(!firstTime) {
                System.out.print(",");
            } else {
                firstTime = false;
            }
            System.out.print(array[i][j]);
        }
    }

    private boolean outOfBounds(int i, int j, int iteration) {
        boolean condition1 = i < 0 || i > m - 1 - iteration;
        boolean condition2 = j < 0 || j > n - 1 - iteration;
        return condition1 || condition2;
    }

    public void printSpiralMatrix() {

        int iteration = 0;
        int i;
        int j;

        while(row.size() < m && col.size() < n) {

            i = iteration;
            j = iteration;

            //col++
            while(true) {
                if(outOfBounds(i, j, iteration)) {
                    j--;
                    break;
                }
                printItemIfValid(i, j);
                j++;
            }
            row.put(iteration, true);

            //row++
            while(true) {
                if(outOfBounds(i, j, iteration)) {
                    i--;
                    break;
                }
                printItemIfValid(i, j);
                i++;
            }
            col.put(n - 1 - iteration, true);

            //col--
            while(true) {
                if(outOfBounds(i, j, iteration)) {
                    j++;
                    break;
                }
                printItemIfValid(i, j);
                j--;
            }
            row.put(m - 1 - iteration, true);

            //row--
            while(true) {
                if(outOfBounds(i, j, iteration)) {
                    i++;
                    break;
                }
                printItemIfValid(i, j);
                i--;
            }
            col.put(iteration, true);

            iteration++;
        }
    }

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        String[] mn = sc.nextLine().split(",");
        int m = Integer.parseInt(mn[0]);
        int n = Integer.parseInt(mn[1]);

        int array[][] = new int[m][n];
        for(int i = 0;  i < m; i++) {
            String[] line = sc.nextLine().split(",");
            if(line.length != n) {
                throw new Exception("Invalid input");
            }
            for(int j = 0; j < n; j++) {
                array[i][j] = Integer.parseInt(line[j]);
            }
        }

        Q1_3_SpiralMatrix sol = new Q1_3_SpiralMatrix(array, m, n);
        sol.printSpiralMatrix();
    }
}
