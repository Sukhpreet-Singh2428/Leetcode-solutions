class Solution {
    public void dfs(int node, List<List<Integer>> adjList, boolean[] vis, int[] ans){
        if(vis[node] == true){
            return;
        }

        vis[node] = true;
        int[] colors = {0, 0, 0, 0};
        for(int it : adjList.get(node)){
            if(vis[it]==false){
                dfs(it, adjList, vis, ans);
            }
            if(ans[it-1] != 0){
                colors[ans[it-1]-1] = 1;
            }
        }
        int color = 1;
        for(int i=0; i<4; i++){
            if(colors[i] == 0){
                color = i+1;
                break;
            }
        }
        ans[node-1] = color;
    }
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n+1; i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0; i<paths.length; i++){
            int u = paths[i][0];
            int v = paths[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        int[] ans = new int[n];

        boolean[] vis = new boolean[n+1];
        for(int i=1; i<n+1; i++){
            if(vis[i] == false){
                dfs(i, adjList, vis, ans);
            }
        }

        return ans;
    }
}