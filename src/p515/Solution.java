package p515;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import data.TreeNode;

public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        inOrder(map, root, 0);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < map.size(); i++) list.add(map.get(i));
        return list;
    }
    
    private void inOrder(Map<Integer, Integer> map, TreeNode root, int n) {
        if (root == null) return;
        if (root.left != null) inOrder(map, root.left, n + 1);
        if (!map.containsKey(n)) map.put(n, root.val);
        else if (map.get(n) < root.val) map.put(n, root.val);
        if (root.right != null) inOrder(map, root.right, n + 1);
    }
}