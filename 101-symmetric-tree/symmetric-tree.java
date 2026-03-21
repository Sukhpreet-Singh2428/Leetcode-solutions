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
    public static boolean isSame(TreeNode root1, TreeNode root2){
        if(root1==null && root2==null){
            return true;
        }
        if(root1==null || root2==null){
            return false;
        }

        if(root1.val != root2.val){
            return false;
        }

        return isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
    }
    public static void mirror(TreeNode root){
        Queue<TreeNode> qu = new ArrayDeque<>();
        if(root==null) return;
        qu.offer(root);

        while(!qu.isEmpty()){
            int levelNum = qu.size();
            TreeNode leftChild = qu.peek().left;
            TreeNode rightChild = qu.peek().right;
            
            qu.peek().left = rightChild;
            qu.peek().right = leftChild;
            if(rightChild!=null) qu.offer(rightChild);
            if(leftChild!=null) qu.offer(leftChild);
            qu.poll();  
        }
    }
    public boolean isSymmetric(TreeNode root) {
        if(root.left==null && root.right==null) return true;
        TreeNode root1 = root.left;
        TreeNode root2 = root.right;
        
        mirror(root2);

        return isSame(root1, root2);
    }
}