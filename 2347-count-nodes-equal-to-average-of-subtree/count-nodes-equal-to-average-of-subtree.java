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
    public static void subtree(TreeNode root, int[] sum, int[] n){
        if(root==null){
            return;
        }

        sum[0] += root.val;
        n[0]++;

        subtree(root.left, sum, n);
        subtree(root.right, sum, n);
    }
    public static void preOrder(TreeNode root, int[] cnt){
        if(root==null){
            return;
        }

        int[] sum = new int[1];
        int[] n = new int[1];
        subtree(root, sum, n);
        int avg = sum[0]/n[0];
        if(avg == root.val){
            cnt[0]++;
        }

        preOrder(root.left, cnt);
        preOrder(root.right, cnt);
    }
    public int averageOfSubtree(TreeNode root) {
        int[] cnt = new int[1];
        preOrder(root, cnt);
        return cnt[0];
    }
}