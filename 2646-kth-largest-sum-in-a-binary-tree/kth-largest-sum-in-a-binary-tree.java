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
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> qu = new ArrayDeque<>();
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
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
            maxHeap.offer(sum);
        }

        if(maxHeap.size() < k){
            return -1;
        }

        long ans = 0;
        for(int i=1; i<=k; i++){
            ans = maxHeap.poll();
        }

        return ans;
    }
}