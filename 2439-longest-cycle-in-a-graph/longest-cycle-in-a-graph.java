class Solution {
    public int bfs(int node, List<List<Integer>> adjList, boolean[] vis){
        int n = adjList.size();

        Queue<Integer> qu = new ArrayDeque<>();
        HashMap<Integer, Integer> mp = new HashMap<>();
        qu.offer(node);
        mp.put(node, 1);
        vis[node] = true;

        int len = -1;
        while(!qu.isEmpty()){
            int p = qu.poll();

            for(int it : adjList.get(p)){
                if(mp.containsKey(it)){
                    len = Math.max(len, mp.get(p) - mp.get(it) + 1);
                }
                else if(it!=-1 && vis[it] == false){
                    qu.offer(it);
                    mp.put(it, mp.get(p)+1);
                    vis[it] = true;
                }
            }
        }

        return len;
    }
    public int longestCycle(int[] edges) {
        int n = edges.length;

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i<n; i++){
            adjList.get(i).add(edges[i]);
        }


        int ans = -1;
        boolean[] vis = new boolean[n];
        for(int i=0; i<n; i++){
            if(vis[i] == false){
                ans = Math.max(ans, bfs(i, adjList, vis));
            } 
        }

        return ans;
    }
}