package p572;

import data.TreeNode;

public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == t) return true;
        if (s == null || t == null) return false;
//        System.out.println(s.val + "," + t.val);
        int sl = size(s.left);
        int sr = size(s.right);
        int tl = size(t.left);
        int tr = size(t.right);
        int sizes = sl + sr;
        int sizet = tl + tr;
//        System.out.println(sl + "," + sr + ":" + tl + "," + tr);
        if (sizes == sizet) return same(s, t);
        if (sl > sizet && isSubtree(s.left, t)) return true;
        if (sr > sizet && isSubtree(s.right, t)) return true;
        if (tl > sizes && isSubtree(s, t.left)) return true;
        if (tr > sizes && isSubtree(s, t.right)) return true;
        return false;
    }
    
    private boolean same(TreeNode s, TreeNode t) {
        if (s == t) return true;
        if (s == null || t == null || s.val != t.val) return false;
        return same(s.left, t.left) && same(s.right, t.right);
    }
    
    private int size(TreeNode t) {
        return size(t, 0);
    }
    
    private int size(TreeNode t, int n) {
        if (t == null) return 0;
        return n + 1 + size(t.left) + size(t.right);
    }
}