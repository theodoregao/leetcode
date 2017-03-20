package p297;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Codec {
    
    private static String NULL = "null";
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return null;
        return preorderEncode(root);
    }
    
    private String preorderEncode(TreeNode node) {
        if (node == null) return NULL + ",";
        String code = node.val + ",";
        code += preorderEncode(node.left);
        code += preorderEncode(node.right);
        return code;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) return null;
        System.out.println(data);
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(",")));
        return preorderDecode(nodes);
    }
    
    private TreeNode preorderDecode(Deque<String> nodes) {
        String token = nodes.poll();
        if (token.equals(NULL)) return null;
        TreeNode node = new TreeNode(Integer.parseInt(token));
        node.left = preorderDecode(nodes);
        node.right = preorderDecode(nodes);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));