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
    public int maximumVal(int[] nums, int l, int r){
        int maxi = Integer.MIN_VALUE;
        int idx = -1;
        for(int i=l; i<=r; i++){
            if(nums[i] > maxi){
                maxi = nums[i];
                idx = i;
            }
        }
        return idx;
    }
    public TreeNode func(int[] nums, int l, int r){
        if(l<0 || r<0) return null;
        if(l>r) return null;

        int maxi = maximumVal(nums, l, r);
        TreeNode root = new TreeNode(nums[maxi]);
        root.left = func(nums, l, maxi-1);
        root.right = func(nums, maxi+1, r);

        return root;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = func(nums, 0, nums.length-1);
        return root;
    }
}