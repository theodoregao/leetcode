package leetcode.google.p173;

import java.util.Stack;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class BSTIterator {
    
    Stack<TreeNode> parents;
    
    private void pushLeft(TreeNode root) {
        while (root != null) {
            parents.push(root);
            root = root.left;
        }
    }

    public BSTIterator(TreeNode root) {
        parents = new Stack<TreeNode>();
        pushLeft(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !parents.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = parents.pop();
        
        if (node.right != null) {
            pushLeft(node.right);
        }
        
        return node.val;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(2);
        root.left = left;
        root.right = new TreeNode(5);
        left.left = new TreeNode(1);
        left.right = new TreeNode(3);
        
        BSTIterator iterator = new BSTIterator(root);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */