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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null || root.val==x || root.val==y){
            return false;
        }

        Queue<TreeNode> qu = new ArrayDeque<>();
        qu.offer(root);

        while(!qu.isEmpty()){
            int lvl = qu.size();
            boolean foundX = false;
            boolean foundY = false;
                
            for(int i=0; i<lvl; i++){
                TreeNode node = qu.peek();
            
                if(node.val==x) foundX = true;
                if(node.val==y) foundY = true;

                if(node.left!=null && node.right!=null){
                    int l = node.left.val;
                    int r = node.right.val;

                    if((l==x && r==y) || (l==y && r==x)){
                        return false;
                    }
                }

                if(node.left!=null) qu.offer(node.left);
                if(node.right!=null) qu.offer(node.right);

                qu.poll();
            }
            if(foundX && foundY) return true;
            if(foundX || foundY) return false;
        }

        return false;
    }
}