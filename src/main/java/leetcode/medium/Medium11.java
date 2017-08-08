package leetcode.medium;

public class Medium11 {

	public static void main(String[] args) {
		System.out.println(maxArea(new int[] { 1, 1, 3, 5, 4, 6, 7, 1, 2, 3, 4 }));
	}

	public static int maxArea(int[] height) {
		int maxWater = -1;
		int left = 0, right = height.length - 1;
		while (left < right) {
			int water = Math.min(height[left], height[right]) * (right - left);
			if (water > maxWater) {
				maxWater = water;
			}
			if (height[left] > height[right]) {
				right--;
			} else {
				left++;
			}
		}
		return maxWater;

	}

}
