package leetcode.easy;

import java.util.Arrays;

public class Easy14 {
	public String longestCommonPrefix(String[] strs) {

		// TODO: boundary case
		if (strs.length == 0)
			return "";
		if (strs.length == 1)
			return strs[0];
		int split = strs.length / 2; // 0-(split-1) split-(length-1)

		String leftCommon = longestCommonPrefix(Arrays.copyOfRange(strs, 0, split));
		String rightCommon = longestCommonPrefix(Arrays.copyOfRange(strs, split, strs.length));

		int lengthOfCommon = 0;
		for (int i = 0; i < leftCommon.length() && i < rightCommon.length(); i++) {
			if (leftCommon.charAt(i) == rightCommon.charAt(i)) {
				lengthOfCommon++;
			} else
				break;
		}
		return leftCommon.substring(0, lengthOfCommon);
	}

	public static void main(String[] args) {
		Easy14 solultion = new Easy14();
		System.out.println(solultion.longestCommonPrefix(new String[] { "aca", "bca" }));
	}
}
