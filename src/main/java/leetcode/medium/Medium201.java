package leetcode.medium;

public class Medium201 {
	public int rangeBitwiseAnd(int m, int n) {
		int numOfRightestWithDiff = 0;
		while (m != n) {
			m >>= 1;
			n >>= 1;
			numOfRightestWithDiff++;
		}
		return m << numOfRightestWithDiff;
	}

	public static void main(String[] args) {
		Medium201 sol = new Medium201();
		System.out.println(sol.rangeBitwiseAnd(0b110, 0b100));
	}
}
