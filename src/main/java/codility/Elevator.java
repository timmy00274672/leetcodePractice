package codility;

import java.util.HashSet;
import java.util.Set;

public class Elevator {

	public static void main(String[] args) {
		Elevator elevator = new Elevator();
		System.out.println(Integer.MAX_VALUE > 100000l*100000l);
		System.out
				.println(elevator.solution(new int[] { 40, 40, 100, 80, 20 }, new int[] { 3, 3, 2, 2, 3 }, 3, 5, 200));
	}

	public int solution(int[] A, int[] B, int M, int X, int Y) {
		int indexOfToBeAdd = 0;
		int stop = 0;
		// while indexOfAlready < A.length
		while (indexOfToBeAdd < A.length) {
			long totalW = 0;
			long totalP = 0;
			Set<Integer> floors = new HashSet<>();
			// let people in
			while (indexOfToBeAdd < A.length && totalP + 1 <= X && totalW + A[indexOfToBeAdd] < Y) {
				totalP++;
				totalW += A[indexOfToBeAdd];
				// select floor
				floors.add(B[indexOfToBeAdd]);
				indexOfToBeAdd++;
			}
			// compute stops
			stop += floors.size();

			// go to ground and stop++
			stop++;
		}
		return stop;
		// write your code in Java SE 8
	}
}
