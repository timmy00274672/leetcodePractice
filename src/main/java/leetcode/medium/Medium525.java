package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class Medium525 {

	public static void main(String[] args) {
		System.out.println(findMaxLength(new int[] { 1,1,1,1,1,1,1,1 }));
	}

	public static int findMaxLength(int[] nums) {
		Map<Integer, Integer> firstPositionMap = new HashMap<Integer, Integer>();
		int sum = 0, maxLength = -1;
		firstPositionMap.put(0, -1);
		for (int i = 0; i < nums.length; i++) {
			sum += (nums[i] == 0) ? (-1) : 1;
			if (!firstPositionMap.containsKey(sum)) {
				firstPositionMap.put(sum, i);
			} else {
				Integer first = firstPositionMap.get(sum);
				maxLength = Math.max(maxLength, i - first + 1);
				// System.out.format("[%d, %d]%n", first + 1, i);
			}
		}
		return (maxLength == -1) ? 0 : (maxLength - 1);
	}
}
