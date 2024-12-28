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
        
        int leftSubtree=calcHeight(root.left);
        int rightSubtree=calcHeight(root.right);
        if(leftSubtree>rightSubtree+1 || rightSubtree>leftSubtree+1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int calcHeight(TreeNode root){
        if(root==null) return 0;

        return 1+Math.max(calcHeight(root.left),calcHeight(root.right));
    }
}