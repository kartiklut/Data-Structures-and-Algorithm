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

        tilt(root.left,res);
        tilt(root.right,res);
        int left=0;
        if(root.left!=null){
            root.val+=root.left.val;
            left=root.left.val;
        }
        int right=0;
        if(root.right!=null){
            root.val+=root.right.val;
            right=root.right.val;
        }
        res[0]+=Math.abs(left-right);
    }
}