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
 //[3],[ 9 20],[ x y 15 7]
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
       if(root==null) return new ArrayList<>();

       Deque<TreeNode> queue=new ArrayDeque<>();
       queue.add(root);
       List<List<Integer>> resultAl=new ArrayList<>();
       while(queue.size()>0){
            List<Integer> currAl=new ArrayList<>();
            int count=queue.size();
            for(int i=0;i<count;i++){
                TreeNode node=queue.pop();
                currAl.add(node.val);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            resultAl.add(currAl);
       }
       return resultAl;
    }

}