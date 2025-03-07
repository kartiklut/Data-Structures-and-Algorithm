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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return root;

        if(root.val==p.val || root.val==q.val) return root;

        TreeNode leftTree=lowestCommonAncestor(root.left,p,q);
        TreeNode rightTree=lowestCommonAncestor(root.right,p,q);

        if(leftTree==null && rightTree!=null) return rightTree;

        if(leftTree!=null && rightTree==null) return leftTree;

        if(leftTree!=null && rightTree!=null) return root;

        return null;
    }
}