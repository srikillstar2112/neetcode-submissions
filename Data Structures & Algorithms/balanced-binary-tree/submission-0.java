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
    private int height(TreeNode node){
        if(node==null){
            return 0;
        }
            int lh=height(node.left);
            int rh=height(node.right);
            return 1+Math.max(lh,rh);
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        int l=height(root.left);
        int r=height(root.right);
        if(Math.abs(l-r)>1) return false;

        boolean left=isBalanced(root.left);
        boolean right=isBalanced(root.right);
        if(!left || !right) return false;

        return true;
    }
}
