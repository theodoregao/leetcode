package p549;

import data.TreeNode;

class Node extends TreeNode {
    int lt = 0;
    int gt = 0;
    int max = 1;
    public Node(int x) {
        super(x);
    }   
}

public class Solution {
    private int max;
    public int longestConsecutive(TreeNode root) {
        max = 0;
        postOrder(toNode(root));
        return max;
    }
    
    private Node toNode(TreeNode root) {
        if (root == null) return null;
        Node node = new Node(root.val);
        if (root.left != null) node.left = toNode(root.left);
        if (root.right != null) node.right = toNode(root.right);
        return node;
    }
    
    private void postOrder(Node root) {
        if (root == null) return;
        if (root.left != null) {
            postOrder((Node) root.left);
            update(root, (Node) root.left);
        }
        if (root.right != null) {
            postOrder((Node) root.right);
            update(root, (Node) root.right);
        }
        max = Math.max(max, root.max);
    }
    
    private void update(Node root, Node child) {
        if (child.val == root.val - 1) {
            root.lt = Math.max(root.lt, child.lt + 1);
        }
        else if (child.val == root.val + 1) {
            root.gt = Math.max(root.gt, child.gt + 1);
        }
        root.max = Math.max(root.max, root.lt + root.gt + 1);
    }
}