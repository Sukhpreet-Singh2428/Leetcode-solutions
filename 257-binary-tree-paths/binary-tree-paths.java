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
    public static void path(TreeNode root, String s, List<String> ls){
        if(root==null){
            return;
        }

        s += root.val;
        if(root.left==null && root.right==null){
            ls.add(s);
            return;
        }
        s += "->";
        path(root.left, s, ls);
        path(root.right, s, ls);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ls = new ArrayList<>();
        path(root, "", ls);
        return ls;
    }
}