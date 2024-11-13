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
    public boolean isValidBST(TreeNode root) {
        List<Integer> sortedList=inorderTraversal(root,new ArrayList<>());
        int currEle=sortedList.get(0);
        for(int i=1;i<sortedList.size();i++){
            if(sortedList.get(i)<=currEle){
                return false;
            }
            currEle=sortedList.get(i);
        }
        return true;
    }

    public List<Integer> inorderTraversal(TreeNode root,List<Integer> resultAl){
        if(root==null) return resultAl;

        inorderTraversal(root.left,resultAl);
        resultAl.add(root.val);
        inorderTraversal(root.right,resultAl);

        return resultAl;
    }
}