package pp1145;

import data.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
	
	private int leftCount;
	private int rightCount;
	
	private int count(TreeNode node, int x) {
		if (node == null) {
			return 0;
		}
		int lc = count(node.left, x);
		int rc = count(node.right, x);
		if (node.val == x) {
			leftCount = lc;
			rightCount = rc;
		}
		return 1 + lc + rc;
	}
	
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        count(root, x);
        int parentCount = n - (1 + leftCount + rightCount);
        return Math.max(parentCount, Math.max(leftCount, rightCount)) > n / 2;
    }
}