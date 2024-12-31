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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return tree(preorder,inorder,new int[1],0,inorder.length-1);
    }

    TreeNode tree(int pre[],int in[],int idx[],int start,int end){
        if(end<0 || start>end || idx[0]>in.length-1) return null;
        TreeNode root=new TreeNode(pre[idx[0]]);
        //find root in pre
        int i=start;
        while(i<=end){
            if(in[i]==pre[idx[0]]) break;
            i++;
        }
        idx[0]++;
        root.left=tree(pre,in,idx,start,i-1);
        root.right=tree(pre,in,idx,i+1,end);
        return root;
    }
}