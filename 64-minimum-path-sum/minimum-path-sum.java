class Pair{
    int i;
    int j;
    int sum;

    public Pair(int i, int j, int sum){
        this.i = i;
        this.j = j;
        this.sum = sum;
    }
}
class Solution {
    public int bfs(int i, int j, int[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> qu = new ArrayDeque<>();

        int[][] dp = new int[n][m];
        for(int[] row : dp){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        qu.offer(new Pair(i, j, grid[i][j]));
        dp[i][j] = grid[i][j];

        while(!qu.isEmpty()){
            Pair p = qu.poll();

            if(p.sum > dp[p.i][p.j]){
                continue;
            }

            if(p.i+1<n){
                int newSum = p.sum + grid[p.i+1][p.j];

                if(newSum < dp[p.i+1][p.j]){
                    dp[p.i+1][p.j] = newSum;
                    qu.offer(new Pair(p.i+1, p.j, newSum));
                }
            } 

            if(p.j+1<m){
                int newSum = p.sum + grid[p.i][p.j+1];

                if(newSum < dp[p.i][p.j+1]){
                    dp[p.i][p.j+1] = newSum;
                    qu.offer(new Pair(p.i, p.j+1, newSum));
                }
            }
        }

        return dp[n-1][m-1];
    }
    public int minPathSum(int[][] grid) {
        return bfs(0, 0, grid);
    }
}