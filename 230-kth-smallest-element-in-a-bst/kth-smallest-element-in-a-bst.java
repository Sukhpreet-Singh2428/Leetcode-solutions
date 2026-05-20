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
    public void Inorder(TreeNode root, List<Integer> ls){
        if(root==null){
            return;
        }

        Inorder(root.left, ls);
        ls.add(root.val);
        Inorder(root.right, ls);
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> ls = new ArrayList<>();

        Inorder(root, ls);

        return ls.get(k-1);
    }
}