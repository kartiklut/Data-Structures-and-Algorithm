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
    public int diameterOfBinaryTree(TreeNode root) {
        //find left max
        //find right max    
        //add 1
        //do same for every node

        int arr[]=dia(root,new int[1]);
        return arr[0];

    }

    int[] dia(TreeNode root,int arr[]){
        if(root==null) return arr;

        int leftMax=calcHeight(root.left);
        int rightMax=calcHeight(root.right);
        arr[0]=Math.max(arr[0],leftMax+rightMax);

        dia(root.left,arr);
        dia(root.right,arr);

        return arr;
    }

    int calcHeight(TreeNode root){
        if(root==null) return 0;

        return 1+Math.max(calcHeight(root.left),calcHeight(root.right));
    }

    
}