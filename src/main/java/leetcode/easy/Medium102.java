package leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import leetcode.medium.TreeNode;

public class Medium102 {
	@SuppressWarnings("unchecked")
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> answer = new ArrayList<>();
		List<TreeNode> nextNodes = new ArrayList<>();
		if (root == null)
			return answer;
		nextNodes.add(root);
		while (nextNodes.size() != 0) {
			answer.add(nextNodes.stream().mapToInt(a -> a.val).boxed().collect(Collectors.toList()));
			ArrayList<TreeNode> tempNodes = new ArrayList<>();
			for (TreeNode p : nextNodes) {
				if (p.left != null)
					tempNodes.add(p.left);
				if (p.right != null)
					tempNodes.add(p.right);
			}
			nextNodes = tempNodes;
		}
		return answer;

	}

	public static void main(String[] args) {

	}
}
