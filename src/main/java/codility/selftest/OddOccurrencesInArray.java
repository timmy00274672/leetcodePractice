package codility.selftest;

import java.util.Arrays;

public class OddOccurrencesInArray {

	public static void main(String[] args) {
		OddOccurrencesInArray solution = new OddOccurrencesInArray();
		System.out.println(10 ^ 10 ^ 11);
		System.out.println(solution.solution(new int[] { 3, 3, 5, 5, 4 }));
	}

	public int solution(int[] A) {
		return Arrays.stream(A).reduce(0, (a, b) -> a ^ b);

	}
}
