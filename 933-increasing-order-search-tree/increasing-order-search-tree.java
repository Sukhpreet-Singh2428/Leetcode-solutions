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
    TreeNode temp;
    public void inorder(TreeNode root){
        if(root==null){
            return;
        }

        inorder(root.left);
        temp.right = new TreeNode(root.val);
        temp = temp.right;
        inorder(root.right);
    }
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummyRoot = new TreeNode(-1);
        temp = dummyRoot;
        inorder(root);

        return dummyRoot.right;
    }
}