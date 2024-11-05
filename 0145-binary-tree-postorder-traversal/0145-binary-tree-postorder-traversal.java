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

 public class Pair{
    TreeNode node;
    int state;

    Pair(TreeNode node,int state){
        this.node=node;
        this.state=state;
    }
 }
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
         if(root==null) return new ArrayList<>();

        //Recursive
        // return postOrder(root,new ArrayList<>());

        //Iterative
        Stack<Pair> stack=new Stack<>();
        Pair initialPair=new Pair(root,1);
        stack.push(initialPair);
        List<Integer> postOrderList=new ArrayList<>();
        while(!stack.isEmpty()){
            Pair peekPair=stack.peek();
            if(peekPair.state==1){
                peekPair.state+=1;
                if(peekPair.node.left!=null){
                    Pair leftPair=new Pair(peekPair.node.left,1);
                    stack.push(leftPair);
                }
            }else if(peekPair.state==2){
                peekPair.state+=1;
                if(peekPair.node.right!=null){
                    Pair rightPair=new Pair(peekPair.node.right,1);
                    stack.push(rightPair);
                }
            }else if(peekPair.state==3){
                postOrderList.add(peekPair.node.val);
                stack.pop();
            }
        }
        return postOrderList;
    }

    public List<Integer> postOrder(TreeNode node,List<Integer> resultAl){
       
        postOrder(node.left,resultAl);
        postOrder(node.right,resultAl);
        resultAl.add(node.val);

        return resultAl;
    }
}