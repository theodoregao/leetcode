package p894;

import java.util.ArrayList;
import java.util.List;

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
    public List<TreeNode> allPossibleFBT(int N) {
        final List<TreeNode> trees = new ArrayList<>();
    	if (N % 2 == 0) {
        	return trees;
        }
    	if (N == 1) {
    		trees.add(new TreeNode(0));
    		return trees;
    	}
        for (int i = 1; i < N; i += 2) {
        	for (TreeNode leftTree: allPossibleFBT(i)) {
        		for (TreeNode rightTree: allPossibleFBT(N - i - 1)) {
                	final TreeNode tree = new TreeNode(0);
                	tree.left = leftTree;
                	tree.right = rightTree;
                	trees.add(tree);
        		}
        	}
        }
        return trees;
    }
}