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
    public static void traversal(TreeNode root, Set<Integer> st){
        if(root==null){
            return;
        }
        if(st.size()>1){
            return;
        }

        st.add(root.val);
        traversal(root.left, st);
        traversal(root.right, st);
    }
    public boolean isUnivalTree(TreeNode root) {
        Set<Integer> st = new HashSet<>();

        traversal(root, st);

        return st.size()==1;
    }
}