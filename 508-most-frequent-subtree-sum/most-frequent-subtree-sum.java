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
    public static void subTreeSum(TreeNode root, int[] sum){
        if(root==null){
            return;
        }

        sum[0] += root.val;
        subTreeSum(root.left, sum);
        subTreeSum(root.right, sum);
    }
    public static void allSubTree(TreeNode root, Map<Integer, Integer> mp){
        if(root==null){
            return;
        }

        int[] sum = new int[1];
        subTreeSum(root, sum);
        mp.put(sum[0], mp.getOrDefault(sum[0], 0)+1);

        allSubTree(root.left, mp);
        allSubTree(root.right, mp);
    }
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> mp = new HashMap<>();
        allSubTree(root, mp);

        int maxF = -1;
        int sum = 0;
        int cnt = 0;
        for(int key : mp.keySet()){
            if(mp.get(key) > maxF){
                maxF = mp.get(key);
                sum = key;
                cnt = 1;
            }
            else if(mp.get(key) == maxF){
                cnt++;
            }
        }
        int[] ans = new int[cnt];
        ans[0] = sum;
        int idx = 1;
        for(int key : mp.keySet()){
            if(mp.get(key) == maxF){
                if(key != sum){
                    ans[idx++] = key;
                }
            }
        }

        return ans;
    }
}