package p098;

import data.TreeNode;

public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBst(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean isValidBst(TreeNode root, long min, long max) {
        if (root == null) return true;
        return min < root.val && root.val < max
                && isValidBst(root.left, min, root.val)
                && isValidBst(root.right, root.val, max);
    }
}