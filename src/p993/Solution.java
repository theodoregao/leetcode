package p993;

import java.util.HashMap;
import java.util.Map;

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
        
    private Map<Integer, EnhancedTreeNode> valToNode;
    
    private class EnhancedTreeNode extends TreeNode {
        EnhancedTreeNode parent;
        int depth;
        public EnhancedTreeNode(TreeNode node, EnhancedTreeNode left, EnhancedTreeNode right, int depth) {
            super(node.val);
            this.left = left;
            this.right = right;
            this.depth = depth;
            if (left != null) {
                left.parent = this;
            }
            if (right != null) {
                right.parent = this;
            }
            valToNode.put(node.val, this);
        }
    }
    
    private EnhancedTreeNode buildTree(TreeNode node, int depth) {
        if (node == null) {
            return null;
        }
        return new EnhancedTreeNode(node,
             buildTree(node.left, depth + 1),
             buildTree(node.right, depth + 1),
             depth);
    }
    
    public boolean isCousins(TreeNode root, int x, int y) {
        valToNode = new HashMap<>();
        buildTree(root, 0);
        EnhancedTreeNode xNode = valToNode.get(x);
        EnhancedTreeNode yNode = valToNode.get(y);
        return xNode.depth == yNode.depth && xNode.parent != yNode.parent;
    }
}
