package leetcode.google.p272;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 * 
 * @author Theodore
 *
 *  用优先级队列保存优先级最低的k个值
 */
public class Solution {
    public List<Integer> closestKValues(TreeNode root, final double target, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                double fabs = Math.abs(o1 - target) - Math.abs(o2 - target);
                return fabs < 0 ? 1 : -1;
            }
        });
        
        preOrderTree(root, k, target, queue);
        
        return new ArrayList<Integer>(queue);
    }
    
    private void preOrderTree(TreeNode root, int k, double target, PriorityQueue<Integer> queue) {
        queue.offer(root.val);
        if (queue.size() > k) queue.poll();
        if (root.left != null) preOrderTree(root.left, k, target, queue);
        if (root.right != null) preOrderTree(root.right, k, target, queue);
    }
}



