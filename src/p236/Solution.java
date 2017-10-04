package p236;

import data.TreeNode;

class Solution {

    static class CustomTreeNode extends TreeNode {
        
        TreeNode treeNode;
        int count;
    
        CustomTreeNode(TreeNode node) {
            super(node.val);
            treeNode = node;
            if (node.left != null) left = new CustomTreeNode(node.left);
            if (node.right != null) right = new CustomTreeNode(node.right);
        }
        
        void calculate() {
            if (left != null) count += ((CustomTreeNode) left).count;
            if (right != null) count += ((CustomTreeNode) right).count;
        }
        
        void add(TreeNode p) {
            if (treeNode == p) {
                count++;
                return;
            }
            else {
                if (left != null) ((CustomTreeNode) left).add(p);
                if (right != null) ((CustomTreeNode) right).add(p);
            }
            
        }
        
        TreeNode find(int count) {
            if (this.count >= count) {
                if (left != null && ((CustomTreeNode) left).count >= count) return ((CustomTreeNode) left).find(count);
                else if (right != null && ((CustomTreeNode) right).count >= count) return ((CustomTreeNode) right).find(count);
                else return treeNode;
            }
            else return null;
        }
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        CustomTreeNode cRoot = new CustomTreeNode(root);
        cRoot.add(p);
        cRoot.add(q);
        postOrderCalculate(cRoot);
        print(cRoot);
        return cRoot.find(2);
    }
    
    private void postOrderCalculate(CustomTreeNode node) {
        if (node == null) return;
        if (node.left != null) postOrderCalculate((CustomTreeNode) node.left);
        if (node.right != null) postOrderCalculate((CustomTreeNode) node.right);
        node.calculate();
    }
    
    private void print(CustomTreeNode node) {
        if (node.left != null) print((CustomTreeNode) node.left);
        if (node.right != null) print((CustomTreeNode) node.right);
    }
    
    public static void main(String[] args) {
//        TreeNode ll = new TreeNode(3);
//        TreeNode lr = new TreeNode(4);
//        
//        TreeNode l = new TreeNode(1);
//        l.left = ll;
//        l.right = lr;
//        
//        TreeNode rl = new TreeNode(5);
//        TreeNode rr = new TreeNode(6);
//        
//        TreeNode r = new TreeNode(2);
//        r.left = rl;
//        r.right = rr;
//        
//        TreeNode root = new TreeNode(0);
//        root.left = l;
//        root.right = r;
//
//        System.out.println(new Solution().lowestCommonAncestor(root, l, r).val);
//        System.out.println(new Solution().lowestCommonAncestor(root, ll, lr).val);
//        System.out.println(new Solution().lowestCommonAncestor(root, rl, rr).val);
//        System.out.println(new Solution().lowestCommonAncestor(root, l, lr).val);
        
        //[-1,0,3,-2,4,null,null,8]
        TreeNode lll = new TreeNode(8);
        
        TreeNode ll = new TreeNode(-2);
        ll.left = lll;
        
        TreeNode lr = new TreeNode(4);
        
        TreeNode l = new TreeNode(0);
        l.left = ll;
        l.right = lr;
        
        TreeNode r = new TreeNode(3);
        
        TreeNode root = new TreeNode(-1);
        root.left = l;
        root.right = r;
        
        System.out.println(new Solution().lowestCommonAncestor(root, lll, r).val);
    }
    
}