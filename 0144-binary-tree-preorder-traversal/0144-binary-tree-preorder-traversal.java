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
        
        //REcursive
        return preOrder(root,new ArrayList<>());
    }

    public List<Integer> preOrder(TreeNode node,List<Integer> resultAl){
        if(node==null) return resultAl;

        resultAl.add(node.val);
        preOrder(node.left,resultAl);
        preOrder(node.right,resultAl);
        return resultAl;
    }
    
    //Iterative 
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     if(root==null) return new ArrayList<>();
    //     Stack<TreeNode> stack=new Stack<>();
    //     stack.push(root);
    //     List<Integer> resultAl=new ArrayList<>();
    //     while(stack.size()>0){
    //         int count=stack.size();
    //         for(int i=0;i<count;i++){
    //             TreeNode node=stack.pop();
    //             resultAl.add(node.val);
    //             if(node.right!=null) stack.push(node.right);
    //             if(node.left!=null) stack.push(node.left);
    //         }
    //     }
    //     return resultAl;
    // }
}