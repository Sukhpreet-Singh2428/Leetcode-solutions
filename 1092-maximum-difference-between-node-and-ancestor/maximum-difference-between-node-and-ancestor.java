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
    public void func(TreeNode root, int val, int[] ans){
        if(root==null){
            return;
        }

        ans[0] = Math.max(ans[0], Math.abs(val-root.val));
        func(root.left, val, ans);
        func(root.right, val, ans);
    }
    public void traversal(TreeNode root, int[] ans){
        if(root==null){
            return;
        }

        func(root, root.val, ans);
        traversal(root.left, ans);
        traversal(root.right, ans);
    }
    public int maxAncestorDiff(TreeNode root) {
        int[] ans = new int[1];
        traversal(root, ans);
        return ans[0];
    }
}