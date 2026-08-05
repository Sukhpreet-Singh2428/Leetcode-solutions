class Solution {
    public void bfs(int source, boolean[] vis, List<List<Integer>> adjList, HashMap<Integer, Boolean> mp){
        Queue<Integer> qu = new ArrayDeque<>();
        qu.offer(source);
        vis[source] = true;
        mp.put(source, true);

        while(!qu.isEmpty()){
            int node = qu.poll();

            for(int it : adjList.get(node)){
                if(!vis[it]){
                    qu.offer(it);
                    vis[it] = true;
                    mp.put(it, true);
                }
            }
        }
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < invocations.length; i++){
            int u = invocations[i][0];
            int v = invocations[i][1];
            adjList.get(u).add(v);
        }

        boolean[] vis = new boolean[n];
        HashMap<Integer, Boolean> mp = new HashMap<>();

        bfs(k, vis, adjList, mp);

        // Check whether any non-suspicious method invokes a suspicious one.
        boolean possible = true;

        for(int[] edge : invocations){
            int u = edge[0];
            int v = edge[1];

            if(!mp.containsKey(u) && mp.containsKey(v)){
                possible = false;
                break;
            }
        }

        List<Integer> ans = new ArrayList<>();

        if(!possible){
            for(int i = 0; i < n; i++){
                ans.add(i);
            }
            return ans;
        }

        for(int i = 0; i < n; i++){
            if(!mp.containsKey(i)){
                ans.add(i);
            }
        }

        return ans;
    }
}