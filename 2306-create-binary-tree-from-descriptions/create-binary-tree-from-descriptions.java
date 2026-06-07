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
class pair {
    TreeNode node;
    boolean isRoot;

    public pair(TreeNode node, boolean isRoot){
        this.node = node;
        this.isRoot = isRoot;
    }
}
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, pair> mp = new HashMap<>();

        for(int[] arr : descriptions){
            if(mp.containsKey(arr[0])){
                TreeNode parent = mp.get(arr[0]).node;
                TreeNode child = mp.containsKey(arr[1]) ? mp.get(arr[1]).node : new TreeNode(arr[1]);
                if(arr[2]==1) parent.left = child;
                else parent.right = child;

                boolean flag = mp.get(arr[0]).isRoot;
                mp.put(arr[0], new pair(parent, flag));
                mp.put(arr[1], new pair(child, false)); 
            }
            else{
                TreeNode parent = new TreeNode(arr[0]);
                TreeNode child = mp.containsKey(arr[1]) ? mp.get(arr[1]).node : new TreeNode(arr[1]);
                if(arr[2]==1) parent.left = child;
                else parent.right = child;

                mp.put(arr[0], new pair(parent, true));
                mp.put(arr[1], new pair(child, false)); 
            }
        }

        TreeNode root = null;

        for(int key : mp.keySet()){
            if(mp.get(key).isRoot==true){
                root = mp.get(key).node;
                break;
            }
        }

        return root;
    }
}