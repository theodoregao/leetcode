package p545;

import java.util.ArrayList;
import java.util.List;

import data.TreeNode;

public class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        list.add(root.val);
        leftBoundary(root.left, list);
        leaf(root.left, list);
        leaf(root.right, list);
        rightBoundary(root.right, list);
        return list;
    }
    
    private void leftBoundary(TreeNode node, List<Integer> list) {
        if (node != null) {
            if (node.left != null) {
                list.add(node.val);
                leftBoundary(node.left, list);
            }
            else if (node.right != null) {
                list.add(node.val);
                leftBoundary(node.right, list);
            }
        }
    }
    
    private void rightBoundary(TreeNode node, List<Integer> list) {
        if (node != null) {
            if (node.right != null) {
                rightBoundary(node.right, list);
                list.add(node.val);
            }
            else if (node.left != null) {
                rightBoundary(node.left, list);
                list.add(node.val);
            }
        }
    }
    
    private void leaf(TreeNode node, List<Integer> list) {
        if (node != null) {
            leaf(node.left, list);
            if (node.left == null && node.right == null) list.add(node.val);
            leaf(node.right, list);
        }
    }
}