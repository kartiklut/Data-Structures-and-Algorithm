/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        //Get parent node map
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.add(root);
        HashMap<TreeNode,TreeNode> parentMap=new HashMap<>();
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode node=queue.remove();
                if(node.left!=null){
                    parentMap.put(node.left,node);
                    queue.add(node.left);
                }
                if(node.right!=null){
                    parentMap.put(node.right,node);
                    queue.add(node.right);
                }
            }
        }


        int distance=0;
        HashMap<TreeNode,Integer> visited=new HashMap<>();
        queue.add(target);
        visited.put(target,1);
        while(!queue.isEmpty()){
            if(distance==k) break;
            distance++;
            List<TreeNode> list=new ArrayList<>();
            while(!queue.isEmpty()){
                list.add(queue.remove());
            }
            for(TreeNode n : list){
                //go up in not visited
                TreeNode parent=parentMap.get(n);
                
                if(parent!=null && !visited.containsKey(parent)){
                    visited.put(parent,1);
                    queue.add(parent);
                }
                //go right in not visited
                if(n.left!=null && !visited.containsKey(n.left)){
                    visited.put(n.left,1);
                    queue.add(n.left);
                }
                //go down in not visited
                if(n.right!=null && !visited.containsKey(n.right)){
                    visited.put(n.right,1);
                    queue.add(n.right);
                }
            }
        }
        List<Integer> list=new ArrayList<>();
        while(!queue.isEmpty()){
            list.add(queue.remove().val);
        }
        return list;
    }
}