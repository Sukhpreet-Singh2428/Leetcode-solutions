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
    public static void leaves(TreeNode root, List<Integer> ls){
        if(root==null){
            return;
        }

        if(root.left==null && root.right==null){
            ls.add(root.val);
        }
        
        leaves(root.left, ls);
        leaves(root.right, ls);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> ls1 = new ArrayList<>();
        leaves(root1, ls1);

        List<Integer> ls2 = new ArrayList<>();
        leaves(root2, ls2);

        if(ls1.size() != ls2.size()) return false;

        return ls1.equals(ls2);
    }
}