package p199;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import data.TreeNode;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int height = inOrder(map, root, 0);
        for (int i = 0; i <= height; i++) list.add(map.get(i));
        return list;
    }
    
    private int inOrder(Map<Integer, Integer> map, TreeNode root, int n) {
        if (root == null) return n - 1;
        int h = n;
        if (root.left != null) h = inOrder(map, root.left, n + 1);
        map.put(n, root.val);
        if (root.right != null) h = Math.max(h, inOrder(map, root.right, n + 1));
        return h;
    }
}