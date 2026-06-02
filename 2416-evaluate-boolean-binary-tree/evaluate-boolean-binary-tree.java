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
    public boolean func(TreeNode root){
        if(root==null){
            return false;
        }
        if(root.left==null && root.right==null){
            if(root.val==0) return false;
            return true;
        }

        boolean l = func(root.left);
        boolean r = func(root.right);

        if(root.val==2) return l || r;
        return l && r;
    }
    public boolean evaluateTree(TreeNode root) {
        return func(root);
    }
}