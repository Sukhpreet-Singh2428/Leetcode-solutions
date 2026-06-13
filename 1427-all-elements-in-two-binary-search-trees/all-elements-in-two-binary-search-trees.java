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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ls1 = new ArrayList<>();
        inorder(root1, ls1);
        List<Integer> ls2 = new ArrayList<>();
        inorder(root2, ls2);

        List<Integer> ans = new ArrayList<>();
        int i=0;
        int j=0;
        while(i<ls1.size() && j<ls2.size()){
            if(ls1.get(i) <= ls2.get(j)){
                ans.add(ls1.get(i));
                i++;
            }
            else{
                ans.add(ls2.get(j));
                j++;
            }
        }
        while(i<ls1.size()){
            ans.add(ls1.get(i));
            i++;
        }
        while(j<ls2.size()){
            ans.add(ls2.get(j));
            j++;
        }

        return ans;
    }
}