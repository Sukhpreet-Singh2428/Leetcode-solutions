class Pair{
    int i;
    int j;
    
    public Pair(int i, int j){
        this.i = i;
        this.j = j;
    }
}
class Solution {
    public int bfs(int i, int j, int m, int n){
        Queue<Pair> qu = new ArrayDeque<>();
        qu.offer(new Pair(i, j));
        int[][] dp = new int[m][n];
        dp[i][j] = 1;

        while(!qu.isEmpty()){
            Pair p = qu.poll();

            if(p.i+1 < m){
                if(dp[p.i+1][p.j] == 0){
                    qu.offer(new Pair(p.i+1, p.j));
                }
                dp[p.i+1][p.j] += dp[p.i][p.j];
            }
            if(p.j+1 < n){
                if(dp[p.i][p.j+1] == 0){
                    qu.offer(new Pair(p.i, p.j+1));
                }
                dp[p.i][p.j+1] += dp[p.i][p.j];
            }
        }

        return dp[m-1][n-1];
    }
    public int uniquePaths(int m, int n) {
        return bfs(0, 0, m, n);
    }
}