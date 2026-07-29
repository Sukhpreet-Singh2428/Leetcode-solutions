class Solution {
    public void dfs(int node, int[][] graph, List<Integer> ls, List<List<Integer>> ans){
        ls.add(node);

        if(node == graph.length-1){
            ans.add(new ArrayList<>(ls));
            return;
        }

        for(int it : graph[node]){
            dfs(it, graph, ls, ans);
            ls.remove(ls.size()-1);
        }

    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();

        int n = graph.length;
        List<Integer> ls = new ArrayList<>();
        int startingNode = 0;
        dfs(startingNode, graph, ls, ans);

        return ans;
    }
}