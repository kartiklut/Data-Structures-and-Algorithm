/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        
        int lH=calculateLRheight(root.left);
        int rH=calculateLRheight(root.right);
        if(Math.abs(lH-rH)>1){
            return false;
        }
        boolean left=isBalanced(root.left);
        boolean right=isBalanced(root.right);
        if(!left || !right){
            return false;
        }
        return true;
    }

    public int calculateLRheight(TreeNode root){
        if(root==null) return 0;

       return  1+Math.max(calculateLRheight(root.left),calculateLRheight(root.right));
    }
}