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
    public static void preOrder(TreeNode root, int sum, int targetSum, List<Integer> ls, List<List<Integer>> ans){
        if(root==null){
            return;
        }

        sum += root.val;
        ls.add(root.val);
        if(root.left==null && root.right==null){
            if(sum==targetSum){
                ans.add(new ArrayList<>(ls));
            }
        }

        preOrder(root.left, sum, targetSum, ls, ans);
        preOrder(root.right, sum, targetSum, ls, ans);
        ls.remove(ls.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        preOrder(root, 0, targetSum, ls,ans);
        return ans;
    }
}