package p099;

public class Solution {
    
    private TreeNode first;
    private TreeNode second;
    private TreeNode prev;
    
    public void recoverTree(TreeNode root) {
        prev = new TreeNode(Integer.MIN_VALUE);
        
        traversal(root);
        
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
    
    private void traversal(TreeNode root) {
        if (root == null) return;
        
        traversal(root.left);
        
        if (first == null && prev.val > root.val) {
            first = prev;
        }
        
        if (first != null && prev.val > root.val) {
            second = root;
        }
        
        prev = root;
        
        traversal(root.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}