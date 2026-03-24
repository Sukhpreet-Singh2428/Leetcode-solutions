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
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> qu = new ArrayDeque<>();
        if(root==null) return root;
        qu.offer(root);

        while(!qu.isEmpty()){
            int levelNum = qu.size();

            for(int i=0; i<levelNum; i++){
                TreeNode top = qu.poll();
                TreeNode leftChild = top.left;
                TreeNode rightChild = top.right;
                top.left = rightChild;
                top.right = leftChild;

                if(rightChild != null) qu.offer(rightChild);
                if(leftChild != null) qu.offer(leftChild);
            }
        }

        return root;
    }
}