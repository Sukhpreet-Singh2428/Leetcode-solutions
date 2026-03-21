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
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> qu = new ArrayDeque<>();
        int ans = 0;
        if(root==null) return ans;
        qu.offer(root);

        while(!qu.isEmpty()){
            int levelNum = qu.size();
            int sum = 0;
            for(int i=0; i<levelNum; i++){
                if(qu.peek().left!=null) qu.offer(qu.peek().left);
                if(qu.peek().right!=null) qu.offer(qu.peek().right);

                sum += qu.poll().val;
            }
            ans = sum;
        }

        return ans;
    }
}