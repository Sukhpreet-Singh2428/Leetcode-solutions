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
    public void bfs(TreeNode root, List<Integer> ls){
        Queue<TreeNode> qu = new ArrayDeque<>();
        qu.offer(root);

        while(!qu.isEmpty()){
            TreeNode node = qu.peek();
            if(node.left != null) qu.offer(node.left);
            if(node.right != null) qu.offer(node.right);

            ls.add(node.val);
            qu.poll();
        }
    }
    public boolean twoSum(List<Integer> ls, int target){
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int i=0; i<ls.size(); i++){
            int x = ls.get(i);
            mp.put(x, i);
        }

        for(int i=0; i<ls.size(); i++){
            int rem = target - ls.get(i);
            if(mp.containsKey(rem) && mp.get(rem)!=i){
                return true;
            }
        }

        return false;
    }
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> ls = new ArrayList<>();
        bfs(root, ls);

        return twoSum(ls, k);
    }
}