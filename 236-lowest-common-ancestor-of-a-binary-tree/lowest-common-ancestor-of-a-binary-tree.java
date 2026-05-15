/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public static int func(TreeNode root, TreeNode target, List<TreeNode> ls){
        if(root==null){
            return 0;
        }
        if(root.val==target.val){
            ls.add(root);
            return 1;
        }

        ls.add(root);
        int l = func(root.left, target, ls);
        if(l==1) return 1;
        int r = func(root.right, target, ls);
        if(r==1) return 1;
        ls.remove(ls.size()-1);

        return 0;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val==p.val || root.val==q.val){
            return root;
        }

        List<TreeNode> ls1 = new ArrayList<>();
        func(root, p, ls1);

        List<TreeNode> ls2 = new ArrayList<>();
        func(root, q, ls2);

        TreeNode ans = null;
        int i=0;
        int j=0;
        while(i<ls1.size() && j<ls2.size()){
            if(ls1.get(i).val==ls2.get(j).val){
                ans = ls1.get(i);
            }
            i++;
            j++;
        }

        return ans;
    }
}