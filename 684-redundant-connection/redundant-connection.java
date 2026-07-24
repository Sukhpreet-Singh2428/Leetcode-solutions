class Solution {
    public boolean dfs(int node, int parent, boolean[] vis, List<List<Integer>> adjList){
        vis[node] = true;

        for(int it : adjList.get(node)){
            if(vis[it] == false){
                if(dfs(it, node, vis, adjList) == true){
                    return true;
                }
            }
            else if(it != parent){
                return true;
            }
        }

        return false;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        List<List<Integer>> adjList = new ArrayList<>(n+1);
        for(int i=0; i<=n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);

            boolean[] vis = new boolean[n+1];
            for(int i=1; i<=n; i++){
                if(vis[i] == false){
                    if(dfs(i, -1, vis, adjList) == true){
                        return edge;
                    }
                }
            }
        }

        return new int[]{0, 0};
    } 
}