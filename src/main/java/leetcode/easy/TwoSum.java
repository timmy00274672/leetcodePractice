package leetcode.easy;

import java.util.Arrays;

public class TwoSum {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(twoSum(new int[] { 3, 2, 4 }, 6)));
	}

	public static int[] twoSum(int[] nums, int target) {
		for (int left = 0; left < nums.length; left++) {
			for (int right = left + 1; right < nums.length; right++) {
				System.out.format("%d, %d%n", left, right);
				if (nums[left] + nums[right] == target) {
					return new int[] { left, right };
				}
			}
		}
		return null;
	}
}
