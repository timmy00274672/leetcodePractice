package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium655 {

	public static void main(String[] args) {
		// level 1
		TreeNode root = new TreeNode(1);

		// level 2
		TreeNode temp = new TreeNode(2);
		root.left = temp;
		root.right = new TreeNode(5);

		// level 3 and 4
		temp.left = new TreeNode(3, new TreeNode(4), null);
		printTree(root);
	}

	public static List<List<String>> printTree(TreeNode root) {
		// BFS
		ArrayList<TreeNode[]> record = new ArrayList<TreeNode[]>();
		record.add(0, null); // dummy
		record.add(1, new TreeNode[] { root });

		boolean withElementThisLevel = true;
		int deepDepth = 1;
		for (int level = 2; withElementThisLevel; level++) {
			withElementThisLevel = false;
			TreeNode[] thisLevel = new TreeNode[1 << (level - 1)], upLevel = record.get(level - 1);

			int index = 0;
			for (int i = 0; i < upLevel.length; i++) {
				if (upLevel[i] == null) {
					thisLevel[index] = null;
					thisLevel[index + 1] = null;
					index += 2;
				} else {
					if (!withElementThisLevel) {
						withElementThisLevel = (upLevel[i].left != null) || (upLevel[i].right != null);
					}
					thisLevel[index] = upLevel[i].left;
					thisLevel[index + 1] = upLevel[i].right;
					index += 2;
				}
			}
			if (withElementThisLevel) {
				record.add(level, thisLevel);
				deepDepth++;
			}
		}

		List<List<String>> answer = new ArrayList<List<String>>();
		int totalLength = (1 << deepDepth )- 1;
		for (int level = 1; level <= deepDepth; level++) {
			TreeNode[] thisLevel = record.get(level);

			String[] thisLevelStringArray = new String[totalLength];
			Arrays.fill(thisLevelStringArray, "");

			int firstIndexOfThisLevel = (1 << (deepDepth - level)) - 1;
			int distance = (1 << (deepDepth - level + 1)) - 1;

			int curr = firstIndexOfThisLevel;
			for (int i = 0; i < thisLevel.length; i++) {
				TreeNode treeNode = thisLevel[i];
				if (treeNode != null) {
					thisLevelStringArray[curr] = Integer.toString(treeNode.val);
				}
				curr = curr + distance + 1;
			}

			List<String> thisLevelList = Arrays.asList(thisLevelStringArray);
			answer.add(thisLevelList);
		}
		return answer;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

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

}
