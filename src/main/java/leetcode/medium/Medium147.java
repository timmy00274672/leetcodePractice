package leetcode.medium;

public class Medium147 {
	public ListNode insertionSortList(ListNode head) {
		ListNode helper = new ListNode(Integer.MIN_VALUE);
		ListNode cur = head;
		ListNode next = null;

		while (cur != null) {
			ListNode pre = helper; // everytime should find from the begining
			next = cur.next;
			// find place to insert node cur
			while (pre.next != null && pre.next.val < cur.val) {
				pre = pre.next;
			}

			// insert cur into pre and pre.next
			cur.next = pre.next;
			pre.next = cur;

			// next time should insert next (we store from the beginning of this loop
			cur = next;
		}
		return helper.next;

	}

}
