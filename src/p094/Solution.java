package p094;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        recursive(list, root);
        return list;
    }
    
    private void recursive(List<Integer> list, TreeNode root) {
        if (root == null) return;
        if (root.left != null) recursive(list, root.left);
        list.add(root.val);
        if (root.right != null) recursive(list, root.right);
    }
}