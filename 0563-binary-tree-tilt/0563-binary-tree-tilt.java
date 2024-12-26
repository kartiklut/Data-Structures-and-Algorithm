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
    public int findTilt(TreeNode root) {
        int res[]=new int[1];
        tilt(root,res);
        return res[0];
    }

    public void tilt(TreeNode root,int res[]){
        if(root==null) return;

        //for curr node calc leftSum and rightSum
        int leftSum=calcChildSum(root.left);
        int rightSum=calcChildSum(root.right);
        res[0]+=Math.abs(leftSum-rightSum);
        //calc maxSofar
        //do same for everynode
        tilt(root.left,res);
        tilt(root.right,res);

    }

    public int calcChildSum(TreeNode root){
        if(root==null) return 0;

        int left=calcChildSum(root.left);
        int right=calcChildSum(root.right);

        return left+right+root.val;
    }
}