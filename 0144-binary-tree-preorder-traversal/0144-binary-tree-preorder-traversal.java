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
    public List<Integer> preorderTraversal(TreeNode root) {
        

        return preOrder(root,new ArrayList<>());
    }

    public List<Integer> preOrder(TreeNode node,List<Integer> resultAl){
        if(node==null) return resultAl;

        resultAl.add(node.val);
        preOrder(node.left,resultAl);
        preOrder(node.right,resultAl);
        return resultAl;
    }
}