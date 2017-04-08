package p105;

import java.util.HashMap;
import java.util.Map;

import data.TreeNode;

public class Solution {
    private int pid;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pid = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return buildTree(map, preorder, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode buildTree(Map<Integer, Integer> map, int[] preorder, int[] inorder, int ilo, int ihi) {
        if (ilo > ihi) return null;
        TreeNode root = new TreeNode(preorder[++pid]);
        int mid = map.get(preorder[pid]);
        root.left = buildTree(map, preorder, inorder, ilo, mid - 1);
        root.right = buildTree(map, preorder, inorder, mid + 1, ihi);
        return root;
    }
}