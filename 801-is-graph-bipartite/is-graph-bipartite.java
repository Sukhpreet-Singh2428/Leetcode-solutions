class Solution {
    public boolean bfs(int start, int[][] graph, int[] color){
        int n = graph.length;
        int m = graph[0].length;

        Queue<Integer> qu = new ArrayDeque<>();
        qu.offer(start);
        color[start] = 0;

        while(!qu.isEmpty()){
            int node = qu.peek();
            qu.poll();

            for(int it : graph[node]){
                if(color[it] == -1){
                    color[it] = 1 - color[node];
                    qu.offer(it);
                }
                else if(color[it] == color[node]){
                    return false;
                }
            }
        }

        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int m = graph[0].length;

        int[] color = new int[n];
        for(int i=0; i<n; i++){
            color[i] = -1;
        }   

        for(int i=0; i<n; i++){
            if(color[i] == -1){
                if(bfs(i, graph, color) == false){
                    return false;
                }
            }
        }

        return true;
    }
}