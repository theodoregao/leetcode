package p173;

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BSTIterator {
    
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushLeft(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        if (!hasNext()) return -1;
        
        TreeNode top = stack.pop();
        int val = top.val;
        
        if (top.right != null) pushLeft(top.right);
        
        return val;
    }
    
    private void pushLeft(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}

/**
Your BSTIterator will be called like this:
BSTIterator i = new BSTIterator(root);
while (i.hasNext()) v[f()] = i.next();
 */