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
    public static void func(TreeNode root, StringBuilder s){
        if(root==null){
            return;
        }
        s.append(root.val);
        
        if(root.left != null){
            s.append('(');
            func(root.left, s);
            s.append(')');
        }
        else if(root.right != null){
            s.append("()");
        }

        if(root.right != null){
            s.append('(');
            func(root.right, s);
            s.append(')');
        }
    }
    public String tree2str(TreeNode root) {
        StringBuilder s = new StringBuilder();
        func(root, s);
        return s.toString();
    }
}