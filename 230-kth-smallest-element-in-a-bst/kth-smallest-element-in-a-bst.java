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
    int val;
    public void inorder(TreeNode root, int k){
        if(root==null){
            return;
        }
        if(cnt>=k){
            return;
        }

        inorder(root.left, k);
        cnt++;
        if(cnt==k){
            val = root.val;
        }
        inorder(root.right, k);
    }
    public int kthSmallest(TreeNode root, int k) {
        cnt = 0;
        val = 0;
        inorder(root, k);

        return val;
    }
}