package pp1110;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	
	private TreeNode delete(TreeNode node, Set<Integer> set, List<TreeNode> list) {
		if (node == null) {
			return null;
		}
		node.left = delete(node.left, set, list);
		node.right = delete(node.right, set, list);
		if (!set.contains(node.val)) {
			return node;
		}
		if (node.left != null) {
			list.add(node.left);
		}
		if (node.right != null) {
			list.add(node.right);
		}
		return null;
	}
	
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        final Set<Integer> set = new HashSet<>();
        for (int v: to_delete) {
        	set.add(v);
        }
        final List<TreeNode> list = new ArrayList<>();
        root = delete(root, set, list);
        if (root != null) {
        	list.add(root);
        }
        return list;
    }
}