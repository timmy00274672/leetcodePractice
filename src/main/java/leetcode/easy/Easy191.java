package leetcode.easy;

public class Easy191 {
	public static void main(String[] args) {
		System.out.println(new Easy191().hammingWeight(Integer.MIN_VALUE));
	}

	public int hammingWeight(int n) {
		int sum = 0;
		for (int i = 0; i < 32; i++) {
			if ((n & (1 << i)) != 0)
				sum++;
		}
		return sum;
	}
}
