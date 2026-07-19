class Solution {
    public List<List<Integer>> adjMatrix_To_adjList(int[][] isConnected){
        int v = isConnected.length;

        List<List<Integer>> adjList = new ArrayList<>(v+1);
        for(int i=0; i<=v; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i<v; i++){
            for(int j=0; j<v; j++){
                if(isConnected[i][j] == 1 && i!=j){
                    adjList.get(i+1).add(j+1);
                }
            }
        }

        return adjList;
    }
    public void dfs(int node, List<List<Integer>> adjList, boolean[] vis){
        vis[node] = true;

        for(int it : adjList.get(node)){
            if(vis[it] == false){
                dfs(it, adjList, vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int v = isConnected.length;

        List<List<Integer>> adjList = adjMatrix_To_adjList(isConnected);

        boolean[] vis = new boolean[v+1];
        int cnt = 0;
        for(int i=1; i<=v; i++){
            if(vis[i] == false){
                cnt++;
                dfs(i, adjList, vis);
            }
        }

        return cnt;
    }
}