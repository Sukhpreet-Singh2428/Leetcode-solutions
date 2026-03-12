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
    public static void preOrder(TreeNode root, int num, int[] ans){
        if(root==null){
            return;
        }

        num = num<<1;
        num = num | root.val;
        if(root.left==null && root.right==null){
            ans[0] += num;
            return;
        }

        preOrder(root.left, num, ans);
        preOrder(root.right, num, ans);
    }
    public int sumRootToLeaf(TreeNode root) {
        int[] ans = new int[1];
        preOrder(root, 0, ans);
        return ans[0];
    }
}