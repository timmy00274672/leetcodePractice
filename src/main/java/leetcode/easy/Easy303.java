package leetcode.easy;

import java.util.Arrays;

public class Easy303 {
	public static void main(String[] args) {
		NumArray array = new NumArray(new int[] { 1, 7, 5, 36, 55, 1, 2 });
		System.out.println(Arrays.toString(array.sumFromFirstOne));
		System.out.println(array.sumRange(0, 1));
	}
}

class NumArray {

	int[] sumFromFirstOne;

	public NumArray(int[] nums) {
		sumFromFirstOne = new int[nums.length];
		int temp = 0;
		for (int index = 0; index < nums.length; index++) {
			temp += nums[index];
			sumFromFirstOne[index] = temp;
		}
	}

	public int sumRange(int i, int j) {
		if (i == 0) {
			return sumFromFirstOne[j];
		}
		return sumFromFirstOne[j] - sumFromFirstOne[i - 1];
	}
}
