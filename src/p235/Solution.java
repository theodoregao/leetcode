package p235;

import java.util.HashSet;
import java.util.Set;

import data.TreeNode;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Set<TreeNode> parentsP = new HashSet<>();
        Set<TreeNode> parentsQ = new HashSet<>();
        getParents(parentsP, root, p);
        getParents(parentsQ, root, q);
        return lowestCommonAncestor(parentsP, parentsQ, root);
    }
    
    private TreeNode lowestCommonAncestor(Set<TreeNode> parentsP, Set<TreeNode> parentsQ, TreeNode root) {
        if (parentsP.contains(root.left) && parentsQ.contains(root.left)) return lowestCommonAncestor(parentsP, parentsQ, root.left);
        else if (parentsP.contains(root.right) && parentsQ.contains(root.right)) return lowestCommonAncestor(parentsP, parentsQ, root.right);
        else return root;
    }
    
    private boolean getParents(Set<TreeNode> parents, TreeNode root, TreeNode node) {
        if (root == null) return false;
        if (root == node
                || (root.left != null && getParents(parents, root.left, node))
                || (root.right != null && getParents(parents, root.right, node))) {
            parents.add(root);
            return true;
        }
        return false;
    }
}