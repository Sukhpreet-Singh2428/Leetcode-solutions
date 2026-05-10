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
    public TreeNode func(TreeNode root1, TreeNode root2){
        if(root1==null && root2==null){
            return null;
        }

        int sum = 0;
        if(root1!=null) sum += root1.val;
        if(root2!=null) sum += root2.val;
        TreeNode root = new TreeNode(sum);

        root.left = func(root1==null ? null : root1.left, root2==null ? null : root2.left);
        root.right = func(root1==null ? null : root1.right, root2==null ? null : root2.right);

        return root;
    }
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null) return root2;
        if(root2==null) return root1;

        return func(root1, root2);
    }
}