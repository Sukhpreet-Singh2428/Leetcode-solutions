class Solution {
    public void dfs(int node, List<List<Integer>> graph, boolean[] vis, HashMap<Integer, List<Integer>> mp){
        vis[node] = true;

        for(int it : graph.get(node)){
            if(mp.containsKey(it)){
                mp.get(it).add(node);
            }
            else{
                List<Integer> ls = new ArrayList<>();
                ls.add(node);
                mp.put(it, ls);
            }

            if(vis[it] == false) dfs(it, graph, vis, mp);
        }
    }
    public void addAncestors(int node, HashMap<Integer, List<Integer>> mp, TreeSet<Integer> st) {
        if(!mp.containsKey(node))return;

        for(int parent : mp.get(node)){
            if(st.add(parent)){
                addAncestors(parent, mp, st);
            }
        }
    }
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            graph.get(u).add(v);
        }

        HashMap<Integer, List<Integer>> mp = new HashMap<>();
        boolean[] vis = new boolean[n];
        for(int i=0; i<n; i++){
            if(vis[i] == false){
                dfs(i, graph, vis, mp);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            TreeSet<Integer> st = new TreeSet<>();

            if(mp.containsKey(i)){
                for(int parent : mp.get(i)){
                    st.add(parent);
                    addAncestors(parent, mp, st);
                }
            }

            ans.add(new ArrayList<>(st));
        }

        return ans;
    }
}