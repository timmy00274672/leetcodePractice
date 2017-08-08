package leetcode.hard;

import java.util.Collections;
import java.util.PriorityQueue;

//https://leetcode.com/problems/find-median-from-data-stream/description/
public class Hard295 {

	public static void main(String[] args) {

		MedianFinder finder = new MedianFinder();
		int[] input = new int[] { 7, 6, 4, 3, 1, 4, 5, 5, 5, 7, 9, 10 };
		for (int i = 0; i < input.length; i++) {
			int j = input[i];
			finder.addNum(j);
			System.out.format("add %d >> %f%n", j, finder.findMedian());
		}
	}

}

class MedianFinder {

	PriorityQueue<Integer> smaller = new PriorityQueue<Integer>(Collections.reverseOrder());
	PriorityQueue<Integer> bigger = new PriorityQueue<Integer>();

	public void addNum(int num) {
		// add
		if (bigger.isEmpty() || num >= bigger.peek()) {
			bigger.add(num);
		} else {
			smaller.add(num);
		}

		// balance
		if (bigger.size() >= smaller.size() + 2) {
			smaller.add(bigger.remove());
		}

		if (smaller.size() >= bigger.size() + 2) {
			bigger.add(smaller.remove());
		}
	}

	public double findMedian() {
		if (smaller.size() > bigger.size()) {
			return smaller.peek();
		} else if (smaller.size() < bigger.size()) {
			return bigger.peek();
		} else {
			return (smaller.peek() + bigger.peek()) / 2.0;
		}

	}
}