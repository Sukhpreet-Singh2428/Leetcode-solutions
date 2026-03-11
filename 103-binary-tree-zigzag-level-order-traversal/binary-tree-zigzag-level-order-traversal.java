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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> qu = new ArrayDeque<>();
        if(root==null) return ans;
        qu.offer(root);
        int idx = -1;

        while(!qu.isEmpty()){
            List<Integer> ls = new ArrayList<>();
            int levelNum = qu.size();
            idx++;

            for(int i=0; i<levelNum; i++){
                if(qu.peek().left != null) qu.offer(qu.peek().left);
                if(qu.peek().right != null) qu.offer(qu.peek().right);

                ls.add(qu.poll().val);
            }

            if((idx&1)==1) Collections.reverse(ls);
            ans.add(ls);
        }

        return ans;
    }
}