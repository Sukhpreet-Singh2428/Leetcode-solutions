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
    public TreeNode searchBST(TreeNode root, int val) {
        if(root.val == val){
            return root;
        }

        TreeNode ans = null;
        while(root != null){
            if(root.val == val){
                ans = root;
                return ans;
            }

            if(root.val < val){
                root = root.right;
            }
            else{
                root = root.left;
            }
        }

        return ans;
    }
}