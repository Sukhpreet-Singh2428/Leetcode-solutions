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
    public void func(TreeNode root, int[] ans){
        if(root==null){
            return;
        }

        if(root.val % 2 == 0){
            if(root.left!=null && root.left.left!=null) ans[0] += root.left.left.val;
            if(root.left!=null && root.left.right!=null) ans[0] += root.left.right.val;
            if(root.right!=null && root.right.left!=null) ans[0] += root.right.left.val;
            if(root.right!=null && root.right.right!=null) ans[0] += root.right.right.val;
        }

        func(root.left, ans);
        func(root.right, ans);      
    }
    public int sumEvenGrandparent(TreeNode root) {
        int[] ans = new int[1];
        func(root, ans);
        return ans[0];
    }
}