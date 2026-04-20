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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        Queue<TreeNode> qu = new ArrayDeque<>();
        qu.offer(root);
        int level = 1;

        while(!qu.isEmpty()){
            int lvlNum = qu.size();
            for(int i=0; i<lvlNum; i++){
                if(qu.peek().left != null) qu.offer(qu.peek().left);
                if(qu.peek().right != null) qu.offer(qu.peek().right);

                if(depth-1 == level){
                    TreeNode curr = qu.peek();
                    TreeNode left = curr.left;
                    TreeNode right = curr.right;
                    TreeNode newNodeleft = new TreeNode(val);
                    TreeNode newNoderight = new TreeNode(val);
                    curr.left = newNodeleft;
                    curr.right = newNoderight;
                    newNodeleft.left = left;
                    newNoderight.right = right;
                }

                qu.poll();
            }
            if(depth-1 == level) break;
            level++;
        }

        return root;
    }
}