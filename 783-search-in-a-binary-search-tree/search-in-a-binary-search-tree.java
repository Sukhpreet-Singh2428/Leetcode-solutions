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
    public int func(TreeNode root, int val, TreeNode[] ans){
        if(root==null){
            return 0;
        }

        if(root.val == val){
            ans[0] = root;
            return 1;
        }

        int l = func(root.left, val, ans);
        if(l==1) return 1;
        int r = func(root.right, val, ans);
        if(r==1) return 1;

        return 0;
    }
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode[] ans = new TreeNode[1];
        func(root, val, ans);
        return ans[0];
    }
}