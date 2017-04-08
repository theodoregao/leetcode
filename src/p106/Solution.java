package p106;

import java.util.HashMap;
import java.util.Map;

import data.TreeNode;

public class Solution {
    private int pid;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        pid = postorder.length;
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return buildTree(map, inorder, 0, inorder.length - 1, postorder);
    }
    
    private TreeNode buildTree(Map<Integer, Integer> map, int[] inorder, int lo, int hi, int[] postorder) {
        if (lo > hi) return null;
        TreeNode root = new TreeNode(postorder[--pid]);
        root.right = buildTree(map, inorder, map.get(root.val) + 1, hi, postorder);
        root.left = buildTree(map, inorder, lo, map.get(root.val) - 1, postorder);
        return root;
    }
    
    public static void main(String[] args) {
        new Solution().buildTree(new int[]{2,1,3}, new int[]{2,3,1});
    }
}