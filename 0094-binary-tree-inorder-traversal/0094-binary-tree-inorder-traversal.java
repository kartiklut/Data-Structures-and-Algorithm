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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultAl=new ArrayList<>();
        while(root!=null){
            if(root.left==null){
                resultAl.add(root.val);
                root=root.right;
            }else{
                //exist and not traversed
                TreeNode curr=root.left;
                while(curr.right!=null && curr.right!=root){
                    curr=curr.right;
                }
                //create link
                if(curr.right==null){
                    curr.right=root;
                    root=root.left;
                }else{
                    curr.right=null;
                    resultAl.add(root.val);
                    root=root.right;
                } 
            }
        }
        return resultAl;
    }
}