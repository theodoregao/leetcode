package p285;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    private boolean found;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        found = false;
        return inorderSuccessorInternal(root, p);
    }
    private TreeNode inorderSuccessorInternal(TreeNode root, TreeNode p) {
        if (root == null) return null;
        TreeNode left = inorderSuccessorInternal(root.left, p);
        if (left != null) return left;
        if (root == p) found = true;
        else if (found) return root;
        if (root.right != null) return inorderSuccessorInternal(root.right, p);
        return null;
    }
}