package leetcode.medium;
//542. 01 Matrix

import java.util.Arrays;

public class Matrix {
	public static void main(String[] args) {
		int[][] array1 = new int[][] { { 1, 1, 0, 0, 1, 0, 0, 1, 1, 0 }, { 1, 0, 0, 1, 0, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 0, 0, 1, 1, 1, 1, 0 }, { 0, 1, 1, 1, 0, 1, 1, 1, 1, 1 }, { 0, 0, 1, 1, 1, 1, 1, 1, 1, 0 },
				{ 1, 1, 1, 1, 1, 1, 0, 1, 1, 1 }, { 0, 1, 1, 1, 1, 1, 1, 0, 0, 1 }, { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 1, 0, 1, 1, 0, 1, 1, 1, 1 }, { 1, 1, 1, 0, 1, 0, 1, 1, 1, 1 } };
		print(updateMatrix(array1));
	}

	private static void print(int[][] array1) {
		for (int[] a : array1)
			System.out.println(Arrays.toString(a));
	}

	public static int[][] updateMatrix(int[][] matrix) {
		int rowNumber = matrix.length;
		int colNumber = matrix[0].length;
		int[][] answer = new int[rowNumber][colNumber];
		for (int row = 0; row < rowNumber; row++) {
			for (int col = 0; col < colNumber; col++) {
				answer[row][col] = 100000; // The number of elements of the given matrix will not exceed 10,000.
			}
		}

		for (int row = 0; row < rowNumber; row++) {
			for (int col = 0; col < colNumber; col++) {
				if (matrix[row][col] == 0) {
					answer[row][col] = 0;
				} else {

					// left
					if (col > 0) {
						answer[row][col] = Math.min(answer[row][col], answer[row][col - 1] + 1);
					}
					// up
					if (row > 0) {
						answer[row][col] = Math.min(answer[row][col], answer[row - 1][col] + 1);
					}
				}
			}
		}

		for (int row = rowNumber - 1; row >= 0; row--) {
			for (int col = colNumber - 1; col >= 0; col--) {
				if (matrix[row][col] == 0) {
					answer[row][col] = 0;
				}

				// right
				if (col < colNumber - 1) {
					answer[row][col] = Math.min(answer[row][col], answer[row][col + 1] + 1);
				}
				// up
				if (row < rowNumber - 1) {
					answer[row][col] = Math.min(answer[row][col], answer[row + 1][col] + 1);
				}
			}
		}

		return answer;

	}
}
