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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> qu = new ArrayDeque<>();
        long maxi = Long.MIN_VALUE;
        int idx = -1;
        int lvl = 1;
        if(root==null) return -1;
        qu.offer(root);

        while(!qu.isEmpty()){
            int levelNum = qu.size();
            long sum = 0;
            for(int i=0; i<levelNum; i++){
                if(qu.peek().left != null) qu.offer(qu.peek().left);
                if(qu.peek().right != null) qu.offer(qu.peek().right);

                sum += qu.poll().val;
            }

           if(sum > maxi){
            idx = lvl;
            maxi = sum;
           }

           lvl++;
        }

        return idx;
    }
}