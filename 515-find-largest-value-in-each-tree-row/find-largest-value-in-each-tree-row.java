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
    public static void levelOrder(TreeNode root, List<Integer> ans){
        Queue<TreeNode> qu = new ArrayDeque<>();
        if(root==null) return;
        qu.offer(root);

        while(!qu.isEmpty()){
            int levelNum = qu.size();
            int maxi = Integer.MIN_VALUE;
            for(int i=0; i<levelNum; i++){
                if(qu.peek().left != null) qu.offer(qu.peek().left);
                if(qu.peek().right != null) qu.offer(qu.peek().right);

                maxi = Math.max(maxi, qu.poll().val);
            }

            ans.add(maxi);
        }
    }
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        levelOrder(root, ans);
        return ans;
    }
}