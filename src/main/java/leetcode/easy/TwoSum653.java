package leetcode.easy;

import java.util.ArrayList;

public class TwoSum653 {

	public static boolean findTarget(TreeNode root, int k) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		inorderAdd(root, list);
		int left = 0, right = list.size() - 1;
		while (left < right) {
			int sum = list.get(left) + list.get(right);
			if (sum == k)
				return true;
			else if (sum < k)
				left++;
			else
				right--;
		}
		return false;
	}

	static void inorderAdd(TreeNode root, ArrayList<Integer> list) {
		if (root == null)
			return;
		inorderAdd(root.left, list);
		list.add(root.val);
		inorderAdd(root.right, list);
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
