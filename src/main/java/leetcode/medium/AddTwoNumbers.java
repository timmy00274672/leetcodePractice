package leetcode.medium;

public class AddTwoNumbers {

	/**
	 * You are given two non-empty linked lists representing two non-negative
	 * integers. The digits are stored in reverse order and each of their nodes
	 * contain a single digit. Add the two numbers and return it as a linked list.
	 * 
	 * You may assume the two numbers do not contain any leading zero, except the
	 * number 0 itself.
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
		// Output: 7 -> 0 -> 8
		// ListNode ln = new ListNode;
	}

	public static class Solution {

		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			ListNode dummy = new ListNode(0), left = l1, right = l2, curr = dummy;
			int carry = 0;
			while (left != null || right != null) {
				int leftNumber = (left != null) ? left.val : 0, rightNumber = (right != null) ? right.val : 0;
				int sum = leftNumber + rightNumber + carry;
				curr.next = new ListNode(sum % 10);
				carry = sum / 10;
				curr = curr.next;
				if (left != null)
					left = left.next;
				if (right != null)
					right = right.next;
			}
			if (carry != 0) {
				curr.next = new ListNode(carry);
			}
			return dummy.next;
		}

	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

	}

}
