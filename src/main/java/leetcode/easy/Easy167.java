package leetcode.easy;

import java.util.Arrays;

public class Easy167 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(twoSum(new int[] { 2, 3, 4 }, 6)));
	}

	public static int[] twoSum(int[] nums, int target) {
		outside: for (int left = 0; left < nums.length; left++) {
			if (nums[left] > target)
				break outside;
			inside: for (int right = left + 1; right < nums.length; right++) {
				System.out.format("%d, %d%n", left, right);
				int sum = nums[left] + nums[right];
				if (sum > target)
					break inside;
				if (sum == target) {
					return new int[] { left + 1, right + 1 };
				}
			}
		}
		return null;

	}
}
