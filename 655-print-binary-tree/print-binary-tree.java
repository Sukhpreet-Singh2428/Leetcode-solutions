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
    public void func(TreeNode root, List<List<String>> ans, int r, int c, int height){
        if(root==null){
            return;
        }

        ans.get(r).set(c, ""+root.val);
        func(root.left, ans, r+1, c-(int)(Math.pow(2, height-r-1)), height);
        func(root.right, ans, r+1, c+(int)(Math.pow(2, height-r-1)), height);
    }
    public int depth(TreeNode root){
        if(root==null){
            return 0;
        }

        int l = depth(root.left);
        int r = depth(root.right);

        return 1 + Math.max(l, r);
    }
    public List<List<String>> printTree(TreeNode root) {
        int height = depth(root)-1;

        int m = height+1;
        int n = (int)(Math.pow(2, height+1)) - 1;

        List<List<String>> ans = new ArrayList<>();
        for(int i=0; i<m; i++){
            List<String> ls = new ArrayList<>();
            for(int j=0; j<n; j++){
                ls.add("");
            }
            ans.add(ls);
        }

        int r = 0;
        int c = (n-1)/2;

        func(root, ans, r, c, height);

        return ans;

        // ans.get(r).set(c, ""+root.val);


    }
}