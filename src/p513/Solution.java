package p513;

import java.util.HashMap;
import java.util.Map;

import data.TreeNode;

public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        inOrder(map, root, 0);
        return map.get(map.size() - 1);
    }
    
    private void inOrder(Map<Integer, Integer> map, TreeNode root, int n) {
        if (root == null) return;
        if (root.left != null) inOrder(map, root.left, n + 1);
        if (!map.containsKey(n)) map.put(n, root.val);
        if (root.right != null) inOrder(map, root.right, n + 1);
    }
}