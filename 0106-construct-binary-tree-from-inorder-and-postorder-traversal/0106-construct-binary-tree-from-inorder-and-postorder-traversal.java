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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int idx[]=new int[1];
        idx[0]=postorder.length-1;
        return tree(postorder,inorder,idx,0,inorder.length-1);
    }

    TreeNode tree(int post[],int in[],int idx[],int start,int end){
        if(end<0 || start>end || idx[0]<0) return null;
        TreeNode root=new TreeNode(post[idx[0]]);
        //find root in pre
        int i=start;
        while(i<=end){
            if(in[i]==post[idx[0]]) break;
            i++;
        }
        idx[0]--;
        root.right=tree(post,in,idx,i+1,end);
        root.left=tree(post,in,idx,start,i-1);
        return root;
    }
}