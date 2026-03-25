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
    public int countNodes(TreeNode root) {
        int cnt = 0;
        Queue<TreeNode> qu = new ArrayDeque<>();
        if(root==null) return cnt;
        qu.offer(root);

        while(!qu.isEmpty()){
            int levelNum = qu.size();
            cnt += levelNum;

            for(int i=0; i<levelNum; i++){
                if(qu.peek().left != null) qu.offer(qu.peek().left);
                if(qu.peek().right != null) qu.offer(qu.peek().right);

                qu.poll();
            }
        }

        return cnt;
    }
}