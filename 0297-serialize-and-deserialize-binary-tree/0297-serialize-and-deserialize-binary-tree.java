/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        StringBuffer sb=new StringBuffer();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode node=queue.remove();
                if(node==null){
                    sb.append("#,");
                }else{
                    sb.append(node.val+",");
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0) return null;
        Queue<TreeNode> queue=new ArrayDeque<>();
        String values[]=data.split(",");
        TreeNode root=new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);
        int idx=1;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode parent=queue.remove();
                if(!values[idx].equals("#")){
                    TreeNode left=new TreeNode(Integer.parseInt(values[idx]));
                    parent.left=left;
                    queue.add(left);
                }
                idx++;
                if(!values[idx].equals("#")){
                    TreeNode right=new TreeNode(Integer.parseInt(values[idx]));
                    parent.right=right;
                    queue.add(right);
                }
                idx++;
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));