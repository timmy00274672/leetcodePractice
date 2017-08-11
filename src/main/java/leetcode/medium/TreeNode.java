package leetcode.medium;

import java.util.List;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		super();
		this.val = val;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return "TreeNode [val=" + val + "]";
	}

	public void printToStd() {
		List<List<String>> tree = Medium655.printTree(this);
		for (List<String> list : tree) {
			System.out.println(list);
		}
	}
}
