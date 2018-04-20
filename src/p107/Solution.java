package p107;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import data.TreeNode;

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        inOrder(map, root, 0);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = map.keySet().size() - 1; i >= 0; i--) list.add(map.get(i));
        return list;
    }
    
    private void inOrder(Map<Integer, List<Integer>> map, TreeNode root, int n) {
        if (root == null) return;
        if (root.left != null) inOrder(map, root.left, n + 1);
        if (!map.containsKey(n)) map.put(n, new ArrayList<Integer>());
        map.get(n).add(root.val);
        if (root.right != null) inOrder(map, root.right, n + 1);
    }
}