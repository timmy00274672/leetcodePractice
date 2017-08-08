package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class Medium3 {
	public int lengthOfLongestSubstring(String s) {
		if (s.length() == 1)
			return 1;

		int left = 0, right = 1; // left (inclusive) and right (exclusive) of slice winsow
		Set<Character> set = new HashSet<Character>();
		set.add(s.charAt(0));
		int winLength = 1;

		int maxLength = 0;

		while (left < s.length() && right < s.length()) {

			if (!set.contains(s.charAt(right))) {
				// if X[right] not in set
				// add into set and shift right
				// update length
				set.add(s.charAt(right));
				right++;
				winLength += 1;
				if (winLength > maxLength)
					maxLength = winLength;
			} else {
				// remove X[left] and update set and length
				set.remove(s.charAt(left));
				left++;
				winLength--;
			}
		}
		return maxLength;

	}

	public static void main(String[] args) {
		System.out.println(new Medium3().lengthOfLongestSubstring("abcabcbb"));
	}
}
