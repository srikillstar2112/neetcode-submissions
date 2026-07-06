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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        preorder(root,sb);
        return sb.toString();
    }
    private void preorder(TreeNode node, StringBuilder sb){
        if(node==null){
             sb.append("N%");
             return;
             }
        sb.append(node.val).append("%");
        preorder(node.left,sb);
        preorder(node.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr=data.split("%");
        Queue<String> q=new LinkedList<>();
        for(String s:arr){
            q.offer(s);
        }
        return buildTree(q);
    }
    private TreeNode buildTree(Queue<String> q){
        String val=q.poll();
        if(val.equals("N")) return null;
        TreeNode node=new TreeNode(Integer.parseInt(val));
        node.left=buildTree(q);
        node.right=buildTree(q);
        return node;
    }
}
