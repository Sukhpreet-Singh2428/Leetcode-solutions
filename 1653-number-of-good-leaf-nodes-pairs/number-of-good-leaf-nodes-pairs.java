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
    int ans;
    public void buildGraph(TreeNode node, HashMap<TreeNode, List<TreeNode>> graph){
        if(node==null){
            return;
        }

        if(graph.containsKey(node)){
            TreeNode left = node.left;
            TreeNode right = node.right;

            if(left!=null) graph.get(node).add(left);
            if(right!=null) graph.get(node).add(right);

            if(left!=null){
                if(graph.containsKey(left)){
                    graph.get(left).add(node);
                }
                else{
                    List<TreeNode> ls = new ArrayList<>();
                    ls.add(node);
                    graph.put(left, ls);
                }
            }

            if(right!=null){
                if(graph.containsKey(right)){
                    graph.get(right).add(node);
                }
                else{
                    List<TreeNode> ls = new ArrayList<>();
                    ls.add(node);
                    graph.put(right, ls);
                }
            }
        }
        else{
            TreeNode left = node.left;
            TreeNode right = node.right;

            List<TreeNode> list = new ArrayList<>();
            if(left!=null) list.add(left);
            if(right!=null) list.add(right);
            graph.put(node, list);

            if(left!=null){
                if(graph.containsKey(left)){
                    graph.get(left).add(node);
                }
                else{
                    List<TreeNode> ls = new ArrayList<>();
                    ls.add(node);
                    graph.put(left, ls);
                }
            }

            if(right!=null){
                if(graph.containsKey(right)){
                    graph.get(right).add(node);
                }
                else{
                    List<TreeNode> ls = new ArrayList<>();
                    ls.add(node);
                    graph.put(right, ls);
                }
            }
        }

        buildGraph(node.left, graph);
        buildGraph(node.right, graph);
    }
    public void func(TreeNode root, Set<TreeNode> leafNode){
        if(root==null){
            return;
        }

        if(root.left==null && root.right==null){
            leafNode.add(root);
        }

        func(root.left, leafNode);
        func(root.right, leafNode);
    }
    public void dfs(int dis, TreeNode node, int k, HashMap<TreeNode, List<TreeNode>> graph, Set<TreeNode> vis, Set<TreeNode> leafNode){
        vis.add(node);

        if(leafNode.contains(node) && dis>0 && dis<=k){
            ans++;
            return;
        }

        if(dis>=k){
            return;
        }

        for(TreeNode it : graph.get(node)){
            if(!vis.contains(it)){
                dfs(dis+1, it, k, graph, vis, leafNode);
            }
        }
    }
    public int countPairs(TreeNode root, int distance) {
        HashMap<TreeNode, List<TreeNode>> graph = new HashMap<>();
        buildGraph(root, graph);

        Set<TreeNode> leafNode = new HashSet<>();
        func(root, leafNode);

        ans = 0;
        for(TreeNode node : leafNode){
            Set<TreeNode> vis = new HashSet<>();;
            dfs(0, node, distance, graph, vis, leafNode);
        }

        return ans/2;
    }
}