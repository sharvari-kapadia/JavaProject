// 4.26.2015: Rotate NXN matrix by 90degrees
package com.practice.ctci.ArraysAndStrings;

public class Q1_6 {
	private int size;

	Q1_6(int size) {
		this.size = size;
	}

	public void printMatrix(int[][] matrix) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public int[][] generateMatrix() {
		int[][] matrix = new int[size][size];
		int count = 10;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				matrix[i][j] = count;
				count++;
			}
		}
		return matrix;
	}

	// Exchanges all elements of column[i] with column[i-size-1]
	private int[][] reverseColumns(int[][] matrix) {
		int temp = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size / 2; j++) {
				temp = matrix[i][j];
				matrix[i][j] = matrix[i][size - j - 1];
				matrix[i][size - j - 1] = temp;
			}
		}
		return matrix;
	}

	// exchanges the elements of top right upper half matrix over main diagonal
	// with bottom left lower half elements
	private int[][] reverseOverMainDiagonal(int[][] matrix) {
		int temp = 0;
		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j < size; j++) {
				temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		return matrix;
	}

	public int[][] rotateMatrixBy90(int[][] matrix) {
		return reverseColumns(reverseOverMainDiagonal(matrix));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q1_6 q = new Q1_6(4);
		int[][] matrix = q.generateMatrix();
		q.printMatrix(matrix);
		q.printMatrix(q.rotateMatrixBy90(matrix));
	}

}
