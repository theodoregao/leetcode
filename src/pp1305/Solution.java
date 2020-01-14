package pp1305;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import data.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
	
	private void pushLeft(Stack<TreeNode> stack, TreeNode node) {
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
	}
	
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        final Stack<TreeNode> stack1 = new Stack<>();
        final Stack<TreeNode> stack2 = new Stack<>();
        final List<Integer> list = new ArrayList<>();
        pushLeft(stack1, root1);
        pushLeft(stack2, root2);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
        	final Stack<TreeNode> stack = stack1.isEmpty() ? stack2 : (stack2.isEmpty() ? stack1 : (stack1.peek().val > stack2.peek().val ? stack2 : stack1));
        	final TreeNode node = stack.pop();
            list.add(node.val);
        	if (node.right != null) {
        		pushLeft(stack, node.right);
        	}
        }
        return list;
    }
}