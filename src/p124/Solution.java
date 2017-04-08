package p124;

import data.TreeNode;

public class Solution {
    public int maxPathSum(TreeNode root) {
        Helper helper = maxPathSumHelper(root);
        return (int) Math.max(helper.sub, helper.full);
    }
    
    private Helper maxPathSumHelper(TreeNode root) {
        if (root == null) return new Helper(Integer.MIN_VALUE, Integer.MIN_VALUE);
        Helper left = maxPathSumHelper(root.left);
        Helper right = maxPathSumHelper(root.right);
        return new Helper(maxSub(left.sub, right.sub, root.val), maxFull(left, right, root.val));
    }
    
    private int maxSub(long left, long right, int val) {
        return (int) Math.max(0, Math.max(left, right)) + val;
    }
    
    private int maxFull(Helper left, Helper right, int val) {
        long max = val;
        max = Math.max(max, left.full);
        max = Math.max(max, right.full);
        max = Math.max(max, left.sub);
        max = Math.max(max, right.sub);
        max = Math.max(max, left.sub + val);
        max = Math.max(max, right.sub + val);
        max = Math.max(max, left.sub + right.sub + val);
        return (int) max;
    }
    
    private class Helper {
        long sub;
        long full;
        public Helper(int sub, int full) {
            this.sub = sub;
            this.full = full;
        }
    }
}