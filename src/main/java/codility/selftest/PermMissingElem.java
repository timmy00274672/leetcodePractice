package codility.selftest;

import java.math.BigInteger;

public class PermMissingElem {
	public static void main(String[] args) {
		int[] input = new int[5];
		for (int i = 0; i < input.length; i++) {
			input[i] = i+2;
		}
		
		PermMissingElem permMissingElem = new PermMissingElem();
		System.out.println(permMissingElem.solution(new int[] {2,3,1,5}));
	
	}

	public int solution(int[] A) {
		int N = A.length;
		//(N + 2) * (N + 1) / 2
		BigInteger sum = BigInteger.valueOf(N+2);
		sum = sum.multiply(BigInteger.valueOf(N+1));
		sum = sum.divide(BigInteger.valueOf(2));
		
		for (int i : A) {
			sum = sum.subtract(BigInteger.valueOf(i));
		}
		return sum.intValue();

	}
}
