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
    public TreeNode func(TreeNode root){
        if(root==null){
            return null;
        }

        TreeNode n1 = func(root.left);
        root.left = n1;
        TreeNode n2 = func(root.right);
        root.right = n2;

        if(n1==null && n2==null && root.val==0){
            return null;
        }

        return root;
    }
    public TreeNode pruneTree(TreeNode root) {
        root = func(root);
        return root;
    }
}