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
    public List<Integer> largestValues(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<Integer> resAl=new ArrayList<>();
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int n=queue.size();
            List<Integer> currList=new ArrayList<>();
            int max=Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                TreeNode node=queue.poll();
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
                currList.add(node.val);
                max=Math.max(node.val,max);
            }
            resAl.add(max);
        }
        return resAl;
    }
}