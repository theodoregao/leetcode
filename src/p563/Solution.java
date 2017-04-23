package p563;

import data.TreeNode;

public class Solution {
    public int findTilt(TreeNode root) {
        return postOrderTravelsal(root).diff;
    }
    
    private Result postOrderTravelsal(TreeNode node) {
        if (node == null) return new Result(0, 0);
        Result left = postOrderTravelsal(node.left);
        Result right = postOrderTravelsal(node.right);
        return new Result(left.diff + right.diff + Math.abs(left.sum - right.sum), left.sum + right.sum + node.val);
    }
    
    private class Result {
        int diff;
        int sum;
        
        Result(int diff, int sum) {
            this.diff = diff; this.sum = sum;
        }
    }
}