package leetcode.facebook.p235;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.left != null && p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        else if (root.right != null && p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        else return root;
    }
}