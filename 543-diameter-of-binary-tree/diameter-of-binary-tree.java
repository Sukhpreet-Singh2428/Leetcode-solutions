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
    public static int height(TreeNode root, int[] maxi){
        if(root==null){
            return 0;
        }

        int l = height(root.left, maxi);
        int r = height(root.right, maxi);

        maxi[0] = Math.max(maxi[0], l+r);

        return 1 + Math.max(l,r);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxi = new int[1];
        height(root, maxi);
        return maxi[0];
    }
}