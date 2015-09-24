package leetcode.google.p270;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 * 
 * @author Theodore
 *
 *  应该有O(logn)的解法
 */
public class Solution {
    public int closestValue(TreeNode root, double target) {
        return closestValue(root, target, root.val);
    }

    private int closestValue(TreeNode root, double target, int val) {
        val = Math.abs(target - val) > Math.abs(target - root.val) ? root.val : val;
        
        if (root.left != null) val = closestValue(root.left, target, val);
        if (root.right != null) val = closestValue(root.right, target, val);
        
        return val;
    }
}