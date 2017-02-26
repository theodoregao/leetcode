package p109;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        int n = 0;
        ListNode node = head;
        while (node != null) {
            n++;
            node = node.next;
        }
        int[] nums = new int[n];
        node = head;
        while (node != null) {
            nums[nums.length - n--] = node.val;
            node = node.next;
        }
        return buildBst(nums, 0, nums.length - 1);
    }
    
    private TreeNode buildBst(int[] nums, int lo, int hi) {
        if (lo > hi) return null;
        int mid = (lo + hi) >> 1;
        TreeNode node = new TreeNode(nums[mid]);
        if (lo <= mid - 1) node.left = buildBst(nums, lo, mid - 1);
        if (mid + 1 <= hi) node.right = buildBst(nums, mid + 1, hi);
        return node;
    }
}







