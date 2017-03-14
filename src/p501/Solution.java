package p501;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    List<Integer> list;
    int count;
    int maxCount;
    int preValue;
    public int[] findMode(TreeNode root) {
        list = new ArrayList<>();
        maxCount = 0;
        preValue = Integer.MIN_VALUE;
        inorder(root);
        int[] values = new int[list.size()];
        for (int i = 0; i < values.length; i++) values[i] = list.get(i);
        return values;
    }
    
    private void inorder(TreeNode node) {
        if (node == null) return;
        System.out.println(node.val);
        if (node.left != null) inorder(node.left);
        
        if (preValue != node.val) {
            preValue = node.val;
            count = 0;
        }
        count++;

        if (maxCount == count) {
            list.add(node.val);
        }
        else if (maxCount < count) {
            list.clear();
            list.add(node.val);
            maxCount = count;
        }
        
        if (node.right != null) inorder(node.right);
    }
}