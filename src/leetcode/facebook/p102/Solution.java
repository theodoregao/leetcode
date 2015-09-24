package leetcode.facebook.p102;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        levelOrder(result, root, 0);
        return result;
    }

    private void levelOrder(List<List<Integer>> result, TreeNode root, int level) {
        if (root == null) return;
        if (result.size() == level) result.add(new ArrayList<Integer>());
        result.get(level).add(root.val);
        if (root.left != null) levelOrder(result, root.left, level + 1);
        if (root.right != null) levelOrder(result, root.right, level + 1);
    }
}