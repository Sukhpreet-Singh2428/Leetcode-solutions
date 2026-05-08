/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public void func(final TreeNode cloned, final TreeNode target, TreeNode[] ans){
        if(cloned==null){
            return;
        }
        if(ans[0] != null){
            return;
        }

        if(cloned.val == target.val){
            ans[0] = cloned;
        }
        func(cloned.left, target, ans);
        func(cloned.right, target, ans);
    }
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        TreeNode[] ans = new TreeNode[1];
        ans[0] = null;

        func(cloned, target, ans);

        return ans[0]; 
    }
}