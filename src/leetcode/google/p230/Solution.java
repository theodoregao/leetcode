package leetcode.google.p230;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * 
 * @author Theodore
 *
 *  ÖÐÐò±éÀú
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    private int count;
    
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        return kthSmallest(root).val;
    }

    private TreeNode kthSmallest(TreeNode root) {
        if (root == null) return null;
        TreeNode node = kthSmallest(root.left);
        if (node != null) return node;
        if (0 == --count) return root;
        return kthSmallest(root.right);
    }
}