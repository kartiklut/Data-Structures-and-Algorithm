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
    int state;
    TreeNode node;

    Pair(TreeNode node,int state){
        this.state=state;
        this.node=node;
    }
} 

class Solution {

    
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null) return new ArrayList<>();
        //Recursive
        // return inOrder(root,new ArrayList<>());

        //Iterative
       Stack<Pair> stack=new Stack<>();
       Pair topPair=new Pair(root,1); //add initial state
       stack.push(topPair);
        List<Integer> resultAl=new ArrayList<>();
       while(!stack.isEmpty()){
            Pair pair=stack.peek();
            if(pair.state==1){
                //Preorder
                pair.state+=1;
                if(pair.node.left!=null){
                    Pair leftPair=new Pair(pair.node.left,1); 
                    stack.push(leftPair);
                }
            }else if(pair.state==2){
                resultAl.add(pair.node.val);
                pair.state+=1;
                 if(pair.node.right!=null){
                    Pair rightPair=new Pair(pair.node.right,1); 
                    stack.push(rightPair);
                }
            }else if(pair.state==3){
                stack.pop();
            }
       }
       return resultAl;
    }





    public List<Integer> inOrder(TreeNode node, List<Integer> resultAl){
        inOrder(node.left,resultAl);
        resultAl.add(node.val);
        inOrder(node.right,resultAl);
        return resultAl;
    }
}