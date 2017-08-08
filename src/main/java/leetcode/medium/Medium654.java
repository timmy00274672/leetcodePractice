package leetcode.medium;

import java.util.Arrays;

//https://leetcode.com/problems/maximum-binary-tree/description/
public class Medium654 {

	public static void main(String[] args) {
		TreeNode node = constructMaximumBinaryTree(new int[] { 3, 2, 1, 6, 0, 5 });
		node.printToStd();
	}

	public static TreeNode constructMaximumBinaryTree(int[] nums) {
		if (nums.length == 0)
			return null;
		// find the index for the maximum
		int max = 0, indexForMax = 0;
		for (int index = 0; index < nums.length; index++) {
			if (nums[index] > max) {
				indexForMax = index;
				max = nums[index];
			}
		}
		// and recursive call this method
		TreeNode node = new TreeNode(max);
		node.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, indexForMax));
		node.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, indexForMax + 1, nums.length));
		return node;

	}
}