package p979;

import data.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
	private int flow;
	
    public int distributeCoins(TreeNode root) {
    	flow = 0;
    	calculateBalance(root);
    	return flow;
    }
    
    private int calculateBalance(TreeNode node) {
    	if (node == null) {
    		return 0;
    	}
    	int lBalance = calculateBalance(node.left);
    	int rBalance = calculateBalance(node.right);
    	flow += Math.abs(lBalance) + Math.abs(rBalance);
    	return node.val - 1 + lBalance + rBalance;
    }
}