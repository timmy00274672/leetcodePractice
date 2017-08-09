package codility.selftest;

import java.util.ArrayList;
import java.util.Arrays;

public class CyclicRotation {

	public static void main(String[] args) {
		int[] solution = new CyclicRotation().solution(new int[] { 3, 8, 9, 7, 6 }, 0);
		System.out.println(Arrays.toString(solution));
		;
	}

	public int[] solution(int[] A, int K) {
		if (A.length == 0)
			return A;
		K = K % (A.length);
		if (K == 0)
			return A;
		int[] answer = new int[A.length];
		for (int i = 0; i < K; i++) {
			answer[i] = A[A.length - K + i];
		}
		for (int i = 0; i < A.length - K; i++) {
			answer[K + i] = A[i];
		}

		return answer;
	}
}
