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
    int cnt = 0;
    public void func(TreeNode root, int maxi){
        if(root==null){
            return;
        }

        if(maxi <= root.val){
            cnt++;
        }
        maxi = Math.max(maxi, root.val);
        func(root.left, maxi);
        func(root.right, maxi);
    }
    public int goodNodes(TreeNode root) {
        int maxi = Integer.MIN_VALUE;
        func(root, maxi);

        return cnt;
    }
}