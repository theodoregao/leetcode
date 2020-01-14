package p889;

import java.util.Arrays;

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
	
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre.length == 0) {
        	return null;
        }
        
        final TreeNode node = new TreeNode(pre[0]);
        if (pre.length == 1) {
        	return node;
        }
        
        int index = 0;
        while (pre[1] != post[index++]) ;
        
        node.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, 1 + index), Arrays.copyOfRange(post, 0, index));
        node.right = constructFromPrePost(Arrays.copyOfRange(pre, 1 + index, pre.length), Arrays.copyOfRange(post, index, post.length - 1));
        return node;
    }
}