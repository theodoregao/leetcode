package pp1008;

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
    
    private int[] vals;
    private int pos;
    
    private TreeNode build(int min, int max) {
        if (pos >= vals.length) {
            return null;
        }
        if (vals[pos] < min || vals[pos] > max) {
            return null;
        }
        final TreeNode node = new TreeNode(vals[pos++]);
        node.left = build(min, node.val);
        node.right = build(node.val, max);
        return node;
    }
    
    public TreeNode bstFromPreorder(int[] preorder) {
        vals = preorder;
        pos = 0;
        return build(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
