package com.practice.hackerrank;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: SKapadia
 * Date: 5/30/16
 * Time: 3:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class Q2_3_MatrixPaths {

    private static class Node {
        int row;
        int col;

        Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int numberOfPaths(int [][]a, int M, int N) {

        Queue<Node> queue = new LinkedList<>();

        int row = 0;
        int col = 0;
        int numOfPaths = 0;

        if(a[row][col] != 0) {
            Node node = new Node(row, col);
            queue.add(node);
        } else {
            return numOfPaths;
        }

        while(!queue.isEmpty()) {
            Node node = queue.remove();
            if(node.row == M-1 && node.col == N-1) {
                numOfPaths++;
                numOfPaths %= 1000000007;
            }

            // left (down)
            row = node.row + 1;
            col = node.col;

            if(areIndexesValid(a, M, N, row, col)) {
                Node newLeftNode = new Node(row, col);
                queue.add(newLeftNode);
            }

            // right
            row = node.row;
            col = node.col + 1;

            if(areIndexesValid(a, M, N, row, col)) {
                Node newRightNode = new Node(row, col);
                queue.add(newRightNode);
            }
        }

        return numOfPaths;
    }

    private static boolean areIndexesValid(int [][]a, int M, int N, int row, int col) {

        if(row >= M || col >= N || a[row][col] == 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        int M = 4;
        int N = 4;

        int[][] a = new int[M][N];
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                a[i][j] = 1;
            }
        }

        System.out.println(Q2_3_MatrixPaths.numberOfPaths(a, M, N));
    }
}
