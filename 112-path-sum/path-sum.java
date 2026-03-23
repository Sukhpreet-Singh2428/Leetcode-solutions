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
    public static void preOrder(TreeNode root, int sum, int targetSum, boolean[] ans){
        if(root==null){
            return;
        }
        if(ans[0]) return;

        sum += root.val;
        if(root.left==null && root.right==null){
            if(sum==targetSum){
                ans[0] = true;
            }
            return;
        }
        preOrder(root.left, sum, targetSum, ans);
        preOrder(root.right, sum, targetSum, ans);
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        boolean[] ans = new boolean[1];
        ans[0] = false;
        preOrder(root, 0, targetSum, ans);

        return ans[0];
    }
}