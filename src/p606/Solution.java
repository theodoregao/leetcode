package p606;

import data.TreeNode;

public class Solution {
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        String str = Integer.toString(t.val);
        String left = tree2str(t.left);
        String right = tree2str(t.right);
        if (left.equals("") && right.equals("")) return str;
        else if (right.equals("")) return str + "(" + left + ")";
        else return str + "(" + left + ")(" + right + ")"; 
    }
}