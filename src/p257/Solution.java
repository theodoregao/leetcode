package p257;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        inOrder(paths, root, "");
        return paths;
    }
    
    private void inOrder(List<String> paths, TreeNode root, String path) {
        if (root == null) return;
        path += path.length() == 0 ? root.val : "->" + root.val;
        if (root.left == null && root.right == null) {
            paths.add(path);
            return;
        }
        if (root.left != null) inOrder(paths, root.left, path);
        if (root.right != null) inOrder(paths, root.right, path);
    }
}