package p298;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public int longestConsecutive(TreeNode root) {
    	if (root == null) return 0;
        return longestConsecutive(root, 1);
    }
    
    private int longestConsecutive(TreeNode root, int v) {
    	if (root == null) return v;
    	int l = 0;
    	int r = 0;
    	l = (root.left != null && root.left.val == root.val + 1) ? longestConsecutive(root.left, v + 1) : longestConsecutive(root.left, 1);
    	r = (root.right != null && root.right.val == root.val + 1) ? longestConsecutive(root.right, v + 1) : longestConsecutive(root.right, 1);
    	return Math.max(v, Math.max(l, r));
    }
}