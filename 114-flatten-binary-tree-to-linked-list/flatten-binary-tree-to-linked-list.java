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
    public void flatten(TreeNode root) {
        TreeNode dummyNode = new TreeNode(-1);
        TreeNode temp = dummyNode;
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;

        while(!st.isEmpty() || curr!=null){
            if(curr != null){
                TreeNode newNode = new TreeNode(curr.val);
                temp.right = newNode;
                temp = temp.right;
                st.push(curr);
                curr = curr.left;
            }
            else{
                curr = st.peek();
                st.pop();
                curr = curr.right;
            }
        }
        
        TreeNode newRoot = dummyNode.right;
        if(root != null) root.val = newRoot.val;
        if(root != null) root.left = null;
        if(root != null) root.right = newRoot.right;
    }
}