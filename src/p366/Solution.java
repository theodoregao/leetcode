package p366;

import java.util.ArrayList;
import java.util.List;

import data.TreeNode;

public class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> leaves = new ArrayList<>();
        if (root == null) return leaves;
        while (root.left != null || root.right != null) {
            List<Integer> leave = new ArrayList<>();
            findLeaves(leave, root);
            removeLeaves(root);
            leaves.add(leave);
        }
        List<Integer> leave = new ArrayList<>();
        leave.add(root.val);
        leaves.add(leave);
        return leaves;
    }
    
    private void findLeaves(List<Integer> leaves, TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) leaves.add(root.val);
        if (root.left != null) findLeaves(leaves, root.left);
        if (root.right != null) findLeaves(leaves, root.right);
    }
    
    private boolean removeLeaves(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return true;
        if (removeLeaves(root.left)) root.left = null;
        if (removeLeaves(root.right)) root.right = null;
        return false;
    }
}