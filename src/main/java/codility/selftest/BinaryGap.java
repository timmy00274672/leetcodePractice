package codility.selftest;

public class BinaryGap {
	public static void main(String[] args) {
		int input = 0b1111010010001;
		BinaryGap solution = new BinaryGap();
		System.out.format("%d [%s] >> %d%n", input, Integer.toBinaryString(input), solution.solution(input));
	}

	public int solution(int N) {

		String binaryString = Integer.toBinaryString(N);
		int lastIndexOfOne = binaryString.indexOf('1');
		if (lastIndexOfOne == -1)
			return 0;

		int maxLength = 0;
		while (true) {
			int nextIndexOfOne = binaryString.indexOf('1', lastIndexOfOne + 1);

			if (nextIndexOfOne == -1) {
				break;
			} else {
				int i = nextIndexOfOne - lastIndexOfOne - 1;
				if (i >= 1)
					maxLength = Math.max(i, maxLength);
			}
			lastIndexOfOne = nextIndexOfOne;
		}

		return maxLength;

	}

}
