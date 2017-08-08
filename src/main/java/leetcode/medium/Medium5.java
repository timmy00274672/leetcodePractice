package leetcode.medium;

public class Medium5 {

	public static void main(String[] args) {
		System.out.println(longestPalindrome(
				"cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc"));
	}

	public static String longestPalindrome(String s) {
		byte[] bytes = s.getBytes();
		int left = 0;
		int maxLength = 1;
		String tempAnswer = s.substring(0, 1);
		for (; left < s.length() - 1; left++) {
			right: for (int right = s.length() - 1; right >= left + 1; right--) {
				if (right - left + 1 < maxLength)
					break right;
				// System.out.format("%d, %d %s %n", left, right, s.substring(left, right + 1));
				for (int index = 0; left + index < right - index; index++) {
					if (bytes[left + index] != bytes[right - index])
						continue right;
				}
				if (right - left + 1 > maxLength) {
					tempAnswer = s.substring(left, right + 1);
					maxLength = tempAnswer.length();
				}
			}
		}
		return tempAnswer;

	}
}
