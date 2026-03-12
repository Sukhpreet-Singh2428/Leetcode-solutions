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
    public static void preOrder(TreeNode root, long[] mini, long[] smini){
        if(root==null){
            return;
        }

        if(root.val < mini[0]){
            smini[0] = mini[0];
            mini[0] = root.val;
        }
        else if(root.val < smini[0] && root.val != mini[0]){
            smini[0] = root.val;
        }

        preOrder(root.left, mini, smini);
        preOrder(root.right, mini, smini);
    }
    public int findSecondMinimumValue(TreeNode root) {
        long[] mini = new long[1];
        mini[0] = Long.MAX_VALUE;
        long[] smini = new long[1];
        smini[0] = Long.MAX_VALUE;
        preOrder(root, mini, smini);
        
        return smini[0] == Long.MAX_VALUE ? -1 : (int)smini[0];
    }
}