class Solution {
    public void dfs(int node, List<List<Integer>> adjList, boolean[] vis, HashSet<Integer> restrict){
        vis[node] = true;

        for(int it : adjList.get(node)){
            if(vis[it]==false && !restrict.contains(it)){
                dfs(it, adjList, vis, restrict);
            }
        }
    }
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        HashSet<Integer> restrict = new HashSet<>();
        for(int x : restricted){
            restrict.add(x);
        }

        boolean[] vis = new boolean[n];

        dfs(0, adjList, vis, restrict);

        int cnt = 0;
        for(boolean x : vis){
            if(x) cnt++;
        }

        return cnt;
    }
}