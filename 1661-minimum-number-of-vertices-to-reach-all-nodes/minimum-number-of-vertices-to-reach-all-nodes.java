class Solution {
    public void dfs(int node, List<List<Integer>> graph, boolean[] vis, boolean[] ans){
        vis[node] = true;

        for(int it : graph.get(node)){
            ans[it] = true;
            if(vis[node] == false) dfs(it, graph, vis, ans);
        }
    }
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<edges.size(); i++){
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);
            graph.get(u).add(v);
        }

        boolean[] vis = new boolean[n];
        boolean[] ans = new boolean[n];
        for(int i=0; i<n; i++){
            if(vis[i] == false){
                dfs(i, graph, vis, ans);
            }
        }

        List<Integer> ls = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(ans[i] == false){
                ls.add(i);
            }
        }

        return ls;
    }
}