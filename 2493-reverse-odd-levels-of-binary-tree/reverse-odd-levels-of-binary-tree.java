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
    public TreeNode reverseOddLevels(TreeNode root) {
        TreeNode node = root;
        Queue<TreeNode> qu = new ArrayDeque<>();
        if(root==null) return root;
        qu.offer(root);
        Stack<Integer> st = new Stack<>();
        int lvl = 0;

        while(!qu.isEmpty()){
            int levelNum = qu.size();
            for(int i=0; i<levelNum; i++){
                if(qu.peek().left != null) qu.offer(qu.peek().left);
                if(qu.peek().right != null) qu.offer(qu.peek().right);

               if(lvl%2==0){
                if(qu.peek().left != null) st.push(qu.peek().left.val);
                if(qu.peek().right != null) st.push(qu.peek().right.val);
               }
               else{
                TreeNode temp = qu.peek();
                temp.val = st.pop();
               }

               qu.poll();
            }

            lvl++;
        }

        return node;
    }
}