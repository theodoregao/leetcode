package p314;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();
        travel(map, root, 0, 0);
        
        List<List<Integer>> list = new ArrayList<>();
        for (Integer key: map.keySet()) list.add(mapToList(map.get(key)));
        return list;
    }
    
    private void travel(Map<Integer, Map<Integer, List<Integer>>> map, TreeNode root, int row, int col) {
    	if (root == null) return;
    	
    	if (!map.containsKey(col)) map.put(col, new TreeMap<Integer, List<Integer>>());
    	if (!map.get(col).containsKey(row)) map.get(col).put(row, new ArrayList<Integer>());
    	map.get(col).get(row).add(root.val);
    	
    	travel(map, root.left, row + 1, col - 1);
    	travel(map, root.right, row + 1, col + 1);
    }
    
    private List<Integer> mapToList(Map<Integer, List<Integer>> map) {
    	List<Integer> list = new ArrayList<>();
    	for (List<Integer> items: map.values()) list.addAll(items);
    	return list;
    }
}