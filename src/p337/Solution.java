package p337;

import data.TreeNode;

public class Solution {
    public int rob(TreeNode root) {
        Value value = robInternal(root);
        return Math.max(value.include, value.exclude);
    }
    private Value robInternal(TreeNode root) {
        if (root == null) return new Value(0, 0);
        Value left = robInternal(root.left);
        Value right = robInternal(root.right);
        Value value = new Value(left.exclude + right.exclude + root.val, maxExclude(left, right));
        return value;
    }
    
    private int maxExclude(Value left, Value right) {
        int max = 0;
        max = Math.max(max, left.include + right.include);
        max = Math.max(max, left.include + right.exclude);
        max = Math.max(max, left.exclude + right.include);
        max = Math.max(max, left.exclude + right.exclude);
        return max;
    }
    
    private static class Value {
        int include;
        int exclude;
        public Value(int include, int exclude) {
            this.include = include;
            this.exclude = exclude;
        }
    }
}