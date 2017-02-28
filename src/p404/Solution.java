package p404;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null) return 0;
		return recursive(root, root.left) + recursive(root, root.right);
	}
	
	private int recursive(TreeNode parent, TreeNode node) {
		if (node == null) return 0;
		else if (node.left == null && node.right == null)
			return parent.left == node ? node.val : 0;
		return recursive(node, node.left) + recursive(node, node.right);
	}
}