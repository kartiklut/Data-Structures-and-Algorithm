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
    public int maxPathSum(TreeNode root) {
        int res[]=new int[1];
        res[0]=Integer.MIN_VALUE;
        findMaxPath(root,res);
        return res[0];
    }

    public int findMaxPath(TreeNode root,int max[]){
        if(root==null) return 0;

        int leftMax=findMaxPath(root.left,max);
        int rightMax=findMaxPath(root.right,max);

        int temp=Math.max(Math.max(leftMax,rightMax)+root.val,root.val);
        int fullPath=leftMax+rightMax+root.val;
        max[0]=Math.max(max[0],Math.max(temp,fullPath));
        return temp;
    }

}