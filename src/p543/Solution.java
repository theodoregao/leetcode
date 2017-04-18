package p543;

import data.TreeNode;

public class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        return postOrderTravel(root).max - 1;
    }
    
    private NodeInfo postOrderTravel(TreeNode node) {
        if (node == null) return new NodeInfo();
        NodeInfo left = postOrderTravel(node.left);
        NodeInfo right = postOrderTravel(node.right);
        return new NodeInfo(Math.max(left.height, right.height) + 1,
                Math.max(left.height + right.height + 1, Math.max(left.max, right.max)));
    }
    
    static class NodeInfo {
        int height;
        int max;
        
        NodeInfo() { this(0, 0); }
        NodeInfo(int height, int max) {
            this.height = height;
            this.max = max;
        }
    }
}