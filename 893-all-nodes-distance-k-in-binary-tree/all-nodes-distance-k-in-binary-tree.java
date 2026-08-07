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
    public void dfs(TreeNode node, HashMap<TreeNode, List<TreeNode>> graph, List<Integer> ans, int cnt, HashSet<TreeNode> vis, int k){
        if(cnt==k){
            ans.add(node.val);
            return;
        }
        vis.add(node);

        for(TreeNode it : graph.get(node)){
            if(!vis.contains(it)){
                vis.add(it);
                dfs(it, graph, ans, cnt+1, vis, k);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(k==0){
            List<Integer> ans = new ArrayList<>();
            ans.add(target.val);
            return ans;
        }

        HashMap<TreeNode, List<TreeNode>> graph = new HashMap<>();
        buildGraph(root, graph);

        List<Integer> ans = new ArrayList<>();
        HashSet<TreeNode> vis = new HashSet<>();
        dfs(target, graph, ans, 0, vis, k);

        return ans;
    }
}