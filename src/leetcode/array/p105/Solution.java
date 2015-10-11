package leetcode.array.p105;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    private int r;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        r = 0;
        return buildTree(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int is, int ie) {
        if (is > ie) return null;
        
        if (is == ie) return new TreeNode(preorder[r++]);
        
        TreeNode treeNode = new TreeNode(preorder[r]);
        
        int c;
        for (c = is; c <= ie; c++) {
            if (preorder[r] == inorder[c]) break;
        }
        
        r++;
        treeNode.left = buildTree(preorder, inorder, is, c - 1);
        treeNode.right = buildTree(preorder, inorder, c + 1, ie);
        
        return treeNode;
    }
    
    public static void main(String[] args) {
        int[] preorder = new int[] {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = new int[] {4, 2, 5, 1, 6, 7, 3};
        
        TreeNode tree = new Solution().buildTree(preorder, inorder);
        printTree(tree);
    }
    
    private static void printTree(TreeNode tree) {
        if (tree.left != null) printTree(tree.left);
        System.out.println(tree.val);
        if (tree.right != null) printTree(tree.right);
    }
}