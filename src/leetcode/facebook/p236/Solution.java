package leetcode.facebook.p236;

import java.util.HashSet;
import java.util.Set;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Set<TreeNode> pParents = new HashSet<TreeNode>();
        Set<TreeNode> qParents = new HashSet<TreeNode>();
        getParents(root, p, pParents);
        getParents(root, q, qParents);
        return getCommonAncestor(root, pParents, qParents);
    }
    
    private TreeNode getCommonAncestor(TreeNode root, Set<TreeNode> pParents, Set<TreeNode> qParents) {
        if (root == null || !pParents.contains(root) || !qParents.contains(root)) return null;
        if (root.left != null && pParents.contains(root.left) && qParents.contains(root.left))
            return getCommonAncestor(root.left, pParents, qParents);
        else if (root.right != null && pParents.contains(root.right) && qParents.contains(root.right))
            return getCommonAncestor(root.right, pParents, qParents);
        else return root;
    }

    public boolean getParents(TreeNode root, TreeNode child, Set<TreeNode> parents) {
        if (root == null) return false;
        boolean leftContains = getParents(root.left, child, parents);
        boolean rightCotains = getParents(root.right, child, parents);
        if(leftContains || rightCotains || root == child) parents.add(root);
        return parents.contains(root);
    }
}