package leetcode.medium;

//https://leetcode.com/problems/guess-number-higher-or-lower-ii/description/
public class Medium375 {

	public static void main(String[] args) {
		System.out.println(getMoneyAmount(100));
	}

	public static int getMoneyAmount(int n) {
		int[][] table = new int[n + 1][n + 1];
		return costFor(table, 1, n);
	}

	static int costFor(int[][] table, int left, int right) {
		if (left >= right)
			return 0;

		// already calculate
		if (table[left][right] != 0)
			return table[left][right];

		int maxCost = Integer.MAX_VALUE;
		for (int select = left; select <= right; select++) {
			// max > always guess the worse situation
			int maxCostForThisSelect = select
					+ Math.max(costFor(table, left, select - 1), costFor(table, select + 1, right));
			maxCost = Math.min(maxCost, maxCostForThisSelect);
		}
		table[left][right] = maxCost;
		return maxCost;

	}

}
