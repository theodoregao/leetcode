package p095;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return recursive(1, n);
    }
    
    private List<TreeNode> recursive(int lo, int hi) {
        List<TreeNode> list = new ArrayList<>();
        if (lo > hi) {
            list.add(null);
            return list;
        }
        for (int i = lo; i <= hi; i++) {
            List<TreeNode> lefts = recursive(lo, i - 1);
            List<TreeNode> rights = recursive(i + 1, hi);
            
            for (TreeNode left: lefts) {
                for (TreeNode right: rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    list.add(copy(root));
                }
            }
        }
        return list;
    }
    
    private TreeNode copy(TreeNode root) {
        if (root == null) return null;
        TreeNode copy = new TreeNode(root.val);
        copy.left = copy(root.left);
        copy.right = copy(root.right);
        return copy;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().generateTrees(3).size());
        System.out.println(new Solution().generateTrees(4).size());
        System.out.println(new Solution().generateTrees(5).size());
    }
}