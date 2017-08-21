package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/most-frequent-subtree-sum/description/
 * 
 * @author timmy
 *
 */
public class Medium508 {

	TreeNode root;
	int frequency = 0;
	Map<Integer, Integer> countMap;

	public int[] findFrequentTreeSum(TreeNode root) {
		if (root == null)
			return new int[] {};
		this.root = root;
		frequency = 0;
		countMap = new HashMap<>();
		sum(root);
		List<Integer> list = new ArrayList<>();
		countMap.forEach((sum, fre) -> {
			if (fre == frequency)
				list.add(sum);
		});
		return list.stream().mapToInt(Integer::intValue).toArray();
	}

	int sum(TreeNode node) {
		int sum = node.val;
		if (node.left != null) {
			sum += sum(node.left);
		}
		if (node.right != null) {
			sum += sum(node.right);
		}
		mapPlusOne(sum);
		return sum;
	}

	private void mapPlusOne(int sum) {
		int fre = countMap.getOrDefault(sum, 0) + 1;
		if (fre > frequency)
			frequency = fre;
		countMap.put(sum, fre);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5, new TreeNode(2), new TreeNode(-3));
		Medium508 sol = new Medium508();
		System.out.println(Arrays.toString(sol.findFrequentTreeSum(root)));
	}

}
