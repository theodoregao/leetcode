package p110;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return isBalanced(root.left, root.right);
    }
    
    private boolean isBalanced(TreeNode l, TreeNode r) {
        if (Math.abs(height(l) - height(r)) > 1) return false;
        else return isBalanced(l) && isBalanced(r);
    }
    
    private int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}