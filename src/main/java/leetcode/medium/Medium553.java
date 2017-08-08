package leetcode.medium;

import java.nio.DoubleBuffer;

//https://leetcode.com/problems/optimal-division/description/
public class Medium553 {

	public static void main(String[] args) {
		System.out.println(optimalDivision(new int[] { 1000, 100, 10, 2 }));
	}

	public static String optimalDivision(int[] nums) {
		Tuple ans = find(new Tuple[nums.length][nums.length], nums, 0, nums.length - 1);
		return ans.strForMax;

	}

	public static class Tuple {
		double max, min;

		public Tuple() {

		}

		public Tuple(double max, double min, String strForMax, String strForMin) {
			super();
			this.max = max;
			this.min = min;
			this.strForMax = strForMax;
			this.strForMin = strForMin;
		}

		String strForMax, strForMin;
	}

	public static Tuple find(Tuple[][] table, int[] nums, int left, int right) {
		if (left > right)
			throw new RuntimeException("Shouldn't happen");

		// already calculate
		if (table[left][right] != null) {
			return table[left][right];
		}
		if (left == right) {
			Tuple tuple = new Tuple(nums[left], nums[left], Integer.toString(nums[left]), Integer.toString(nums[left]));
			table[left][right] = tuple;
			return tuple;
		}

		Tuple tuple = new Tuple();
		tuple.max = Integer.MIN_VALUE;
		tuple.min = Integer.MAX_VALUE;

		for (int select = left; select < right; select++) {
			Tuple leftTuple = find(table, nums, left, select);
			Tuple rightTuple = find(table, nums, select + 1, right);

			double maxForThisSelect = leftTuple.max / rightTuple.min;
			double minForThisSelect = leftTuple.min / rightTuple.max;

			boolean lastone = select + 1 == right;
			if (maxForThisSelect > tuple.max) {
				tuple.max = maxForThisSelect;
				//take care of redundant parenthesis
				tuple.strForMax = lastone ? String.format("%s/%s", leftTuple.strForMax, rightTuple.strForMin)
						: String.format("%s/(%s)", leftTuple.strForMax, rightTuple.strForMin);
			}

			if (minForThisSelect < tuple.min) {
				tuple.min = minForThisSelect;
				tuple.strForMin = lastone ? String.format("%s/%s", leftTuple.strForMin, rightTuple.strForMax)
						: String.format("%s/(%s)", leftTuple.strForMin, rightTuple.strForMax);
			}
		}
		table[left][right] = tuple;
		return tuple;

	}
}
