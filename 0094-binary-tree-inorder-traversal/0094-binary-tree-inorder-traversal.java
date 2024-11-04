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
        
        return inOrder(root,new ArrayList<>());
    }

    public List<Integer> inOrder(TreeNode node, List<Integer> resultAl){
        if(node==null) return resultAl;

        inOrder(node.left,resultAl);
        resultAl.add(node.val);
        inOrder(node.right,resultAl);
        return resultAl;
    }
}