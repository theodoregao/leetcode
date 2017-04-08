package p115;

import java.util.HashMap;
import java.util.Map;

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
}

public class Solution {
    public void connect(TreeLinkNode root) {
        Map<Integer, TreeLinkNode> map = new HashMap<>();
        inOrder(map, root, 0);
    }
    private void inOrder(Map<Integer, TreeLinkNode> map, TreeLinkNode root, int height) {
        if (root == null) return;
        if (root.left != null) inOrder(map, root.left, height + 1);
        root.next = null;
        if (map.containsKey(height)) map.get(height).next = root;
        map.put(height, root);
        if (root.right != null) inOrder(map, root.right, height + 1);
    }
}