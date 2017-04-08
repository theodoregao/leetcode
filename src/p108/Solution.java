package p108;

import data.TreeNode;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return toBst(nums, 0, nums.length - 1);
    }
    
    private TreeNode toBst(int[] nums, int lo, int hi) {
        if (lo > hi) return null;
        int mid = (lo + hi) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = toBst(nums, lo, mid - 1);
        root.right = toBst(nums, mid + 1, hi);
        return root;
    }
}