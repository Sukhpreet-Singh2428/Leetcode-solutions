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
    public int postOrder(TreeNode root, int[] ans){
        if(root==null){
            return 0;
        }

        int l = postOrder(root.left, ans);
        int r = postOrder(root.right, ans);
        ans[0] += Math.abs(l-r);

        return root.val + l+r;
    }
    public int findTilt(TreeNode root) {
        int[] ans = new int[1];
        postOrder(root, ans);
        return ans[0];
    }
}