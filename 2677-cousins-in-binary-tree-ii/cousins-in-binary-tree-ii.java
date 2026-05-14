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
    public TreeNode replaceValueInTree(TreeNode root) {

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        root.val = 0;

        while(!q.isEmpty()) {

            int size = q.size();

            int nextLevelSum = 0;

            List<TreeNode> parents = new ArrayList<>();

            // calculate next level total sum
            for(int i = 0; i < size; i++) {

                TreeNode node = q.poll();

                parents.add(node);

                if(node.left != null) {
                    nextLevelSum += node.left.val;
                    q.offer(node.left);
                }

                if(node.right != null) {
                    nextLevelSum += node.right.val;
                    q.offer(node.right);
                }
            }

            // update child values
            for(TreeNode node : parents) {

                int siblingSum = 0;

                if(node.left != null) {
                    siblingSum += node.left.val;
                }

                if(node.right != null) {
                    siblingSum += node.right.val;
                }

                if(node.left != null) {
                    node.left.val = nextLevelSum - siblingSum;
                }

                if(node.right != null) {
                    node.right.val = nextLevelSum - siblingSum;
                }
            }
        }

        return root;
    }
}