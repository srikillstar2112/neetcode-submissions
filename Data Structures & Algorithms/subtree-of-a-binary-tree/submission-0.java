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
    private boolean isSame(TreeNode root1, TreeNode root2){
        if(root1==null || root2==null){
            return (root1==root2);
        }
        return (root1.val==root2.val) && isSame(root1.left,root2.left) && isSame(root1.right,root2.right);
    }
    public boolean isSubtree(TreeNode root, TreeNode subroot) {
        if(subroot==null){
            return true;
        }
        if(root==null){
            return false;
        }
        if(isSame(root,subroot)) return true;
        return isSubtree(root.left,subroot) || isSubtree(root.right,subroot);
    }
}
