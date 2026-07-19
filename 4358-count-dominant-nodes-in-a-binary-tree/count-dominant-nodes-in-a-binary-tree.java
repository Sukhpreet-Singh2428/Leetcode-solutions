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
    int cnt;
    public int postOrder(TreeNode root){
        if(root==null){
            return 0;
        }

        int l = postOrder(root.left);
        int r = postOrder(root.right);

        if(root.val>=l && root.val>=r){
            cnt++;
        }

        return Math.max(root.val, Math.max(l, r));
    }
    public int countDominantNodes(TreeNode root) {
        if(root.left==null && root.right==null){
            return 1;
        }

        cnt = 0;
        postOrder(root);

        return cnt;
    }
}