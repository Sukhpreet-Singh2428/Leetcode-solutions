class Solution {
    public int findJudge(int n, int[][] trust) {
        if(trust.length==0 && n==1) return 1;
        if(trust.length==0) return -1;
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();

        for(int i=0; i<trust.length; i++){
            int a = trust[i][0];
            int b = trust[i][1];

            if(!graph.containsKey(a)){
                HashSet<Integer> ls = new HashSet<>();
                ls.add(b);
                graph.put(a, ls);
            }
            else{
                graph.get(a).add(b);
            }
        }

        for(int i=1; i<=n; i++){
            if(!graph.containsKey(i)){
                boolean skip = false;
                int cnt = 0;
                for(int key : graph.keySet()){
                    if(!graph.get(key).contains(i)) skip = true;
                    if(skip) break;
                    cnt++;
                }
                if(!skip && cnt==n-1) return i;
            }
        }

        return -1;
    }
}