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
    public static void levelOrder(TreeNode root, int[] ans){
        Queue<TreeNode> qu = new ArrayDeque<>();
        if(root==null) return;
        qu.offer(root);
        ans[0] = -1;

        while(!qu.isEmpty()){
            int levelNum = qu.size();
            for(int i=0; i<levelNum; i++){
                if(qu.peek().left != null) qu.offer(qu.peek().left);
                if(qu.peek().right != null) qu.offer(qu.peek().right);

                if(i==0) ans[0] = qu.peek().val;
                qu.poll();
            }
        }
    }
    public int findBottomLeftValue(TreeNode root) {
        int[] ans = new int[1];
        levelOrder(root, ans);
        return ans[0];
    }
}