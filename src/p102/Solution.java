package p102;

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
        List<List<Integer>> list = new ArrayList<>();
        travel(list, root, 0);
        return list;
    }
    
    private void travel(List<List<Integer>> list, TreeNode root, int h) {
    	if (root == null) return;
    	if (list.size() <= h) list.add(new ArrayList<Integer>());
    	list.get(h).add(root.val);
    	travel(list, root.left, h + 1);
    	travel(list, root.right, h + 1);
    }
}