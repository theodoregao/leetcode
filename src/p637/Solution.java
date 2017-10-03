package p637;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import data.TreeNode;

public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        travel(map, root, 0);
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < map.size(); i++) {
            double sum = 0;
            int count = 0;
            for (int v: map.get(i)) {
                sum += v;
                count++;
            }
            list.add(sum / count);
        }
        return list;
    }
    
    private void travel(Map<Integer, List<Integer>> map, TreeNode node, int level) {
        if (node == null) return;
        if (!map.containsKey(level)) map.put(level, new ArrayList<>());
        List<Integer> list = map.get(level);
        list.add(node.val);
        travel(map, node.left, level + 1);
        travel(map, node.right, level + 1);
    }
}