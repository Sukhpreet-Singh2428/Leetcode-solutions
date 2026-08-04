class Solution {
    public boolean bfs(int source, int destination, List<List<Integer>> adjList, boolean[] vis){
        Queue<Integer> qu = new ArrayDeque<>();
        qu.offer(source);
        vis[source] = true;

        while(!qu.isEmpty()){
            int node = qu.peek();
            qu.poll();

            for(int it : adjList.get(node)){
                if(vis[it] == false){
                    if(it == destination) return true;
                    qu.offer(it);
                    vis[it] = true; 
                }
            }
        }

        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(edges.length==0 && source==destination) return true;
        if(source == destination) return true;
        
        List<List<Integer>> adjList = new ArrayList<>(n);
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        boolean[] vis = new boolean[n];
        return bfs(source, destination, adjList, vis);
    }
}