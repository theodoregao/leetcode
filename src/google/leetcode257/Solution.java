package google.leetcode257;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> rst = new ArrayList<String>();
        Stack<Integer> parents = new Stack<Integer>();
        
        if (root != null) {
            rst.addAll(generatePaths(root, parents));
        }
        
        return rst;
    }

    private List<String> generatePaths(TreeNode root, Stack<Integer> parents) {
        List<String> rst = new ArrayList<String>();

        if (root.left == null && root.right == null) {
            String path = "";
            for (Integer parent: parents) path += parent + "->";
            path += root.val;
            rst.add(path);
        }
        
        else {
            parents.push(root.val);
            if (root.left != null) {
                rst.addAll(generatePaths(root.left, parents));
            }
            
            if (root.right != null) {
                rst.addAll(generatePaths(root.right, parents));
            }
            parents.pop();
        }
        
        return rst;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = root.left = new TreeNode(2);
        TreeNode right = root.right = new TreeNode(3);
        left.right = new TreeNode(5);
        right.left = new TreeNode(100);
        right.right = new TreeNode(101);
        
        System.out.println(new Solution().binaryTreePaths(root).toString());
    }
}