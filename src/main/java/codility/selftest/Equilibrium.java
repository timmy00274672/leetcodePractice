package codility.selftest;

public class Equilibrium {

	public static void main(String[] args) {
		Equilibrium solution = new Equilibrium();
		int[] a = new int[] { -1, 1, 500 };
		System.out.println(solution.solution(a));
	}

	public int solution(int[] A) {
		long[] sum = new long[A.length + 1];
		sum[0] = 0;
		long tempSum = 0;
		for (int index = 1; index < sum.length; index++) {
			tempSum += A[index - 1];
			sum[index] = tempSum;
		}
		int answer = -1;
		for (int slectIndex = 0; slectIndex < A.length; slectIndex++) {
			if ((sum[A.length] - sum[slectIndex + 1]) == sum[slectIndex]) {
				answer = slectIndex;
				break;
			}
		}
		return answer;
		// write your code in Java SE 8
	}

}
