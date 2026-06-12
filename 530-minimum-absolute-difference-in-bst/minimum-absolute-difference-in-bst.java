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
    public void inorder(TreeNode root, List<Integer> ls){
        if(root==null){
            return;
        }

        inorder(root.left, ls);
        ls.add(root.val);
        inorder(root.right, ls);
    }
    
    public int getMinimumDifference(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        inorder(root, ls);

        int ans = Integer.MAX_VALUE;
        for(int i=1; i<ls.size(); i++){
            ans = Math.min(ans, ls.get(i)-ls.get(i-1));
        }

        return ans;
    }
}