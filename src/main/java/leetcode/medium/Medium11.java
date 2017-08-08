package leetcode.medium;

public class Medium11 {

	public static void main(String[] args) {

	}

	public static int maxArea(int[] height) {
		int maxWater = -1;
		for (int left = 0; left < height.length; left++) {
			int rightHeightForMax = -1;
			for (int right = height.length - 1; right > left; right--) {
				if (height[right] > rightHeightForMax) {
					int water = Math.min(height[left], height[right]) * (right - left);
					if (water > maxWater) {
						maxWater = water;
						rightHeightForMax = height[right];
					}
				}
			}
		}
		return maxWater;

	}

}
