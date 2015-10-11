package leetcode.array.p106;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    private int[] inorder;
    private int[] postorder;
    private int c;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        c = postorder.length - 1;
        return buildTree(0, inorder.length - 1);
    }
    
    private TreeNode buildTree(int s, int e) {
        if (s > e) return null;
        if (s == e) return new TreeNode(postorder[c--]);
        
        int center;
        for (center = s; center <= e; center++) if (inorder[center] == postorder[c]) break;
        
        TreeNode treeNode = new TreeNode(postorder[c--]);
        
        treeNode.right = buildTree(center + 1, e);
        treeNode.left = buildTree(s, center - 1);
        
        return treeNode;
    }
    
    public static void main(String[] args) {
        int[] inorder = new int[] {4, 2, 5, 1, 6, 7, 3};
        int[] postorder = new int[] {4, 5, 2, 7, 6, 3, 1};
        
        TreeNode tree = new Solution().buildTree(inorder, postorder);
        printTree(tree);
    }
    
    private static void printTree(TreeNode tree) {
        if (tree.left != null) printTree(tree.left);
        System.out.println(tree.val);
        if (tree.right != null) printTree(tree.right);
    }
}