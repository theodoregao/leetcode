package p437;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return recursive(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    private int recursive(TreeNode root, int sum) {
        if (root == null) return 0;
        sum -= root.val;
        return (sum == 0 ? 1 : 0) + recursive(root.left, sum) + recursive(root.right, sum);
    }
}