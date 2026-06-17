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
    public void inorder(TreeNode root, List<Integer> ls){
        if(root==null){
            return;
        }

        inorder(root.left, ls);
        ls.add(root.val);
        inorder(root.right, ls);
    }
    public void inorder(TreeNode root, int val1, int val2){
        if(root==null){
            return;
        }
        
        if(root.val == val1){
            root.val = val2;
        }
        else if(root.val == val2){
            root.val = val1;
        }

        inorder(root.left, val1, val2);
        inorder(root.right, val1, val2);
    }
    public void recoverTree(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        inorder(root, ls);

        Integer val1 = null;
        Integer val2 = null;
        for(int i=1; i<ls.size(); i++){
            if(ls.get(i) < ls.get(i-1)){
                if(val1==null) val1 = ls.get(i-1);
                val2 = ls.get(i);
            }
        }

        inorder(root, val1, val2);
    }
}