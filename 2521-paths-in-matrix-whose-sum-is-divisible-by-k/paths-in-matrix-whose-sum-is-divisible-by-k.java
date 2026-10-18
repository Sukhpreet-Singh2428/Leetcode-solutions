class Solution {
    int MOD = 1_000_000_007;
    int[][][] dp;
    public int dfs(int r, int c, int[][] grid, int k, int n, int m, int[] drow, int[] dcol, long sum){
        if(r==n-1 && c==m-1){
            return sum%k==0 ? 1 : 0;
        }

        int rem = (int) (sum % k);

        if (dp[r][c][rem] != -1) {
            return dp[r][c][rem];
        }

        int cnt = 0;

        for(int i=0; i<2; i++){
            int row = r + drow[i];
            int col = c + dcol[i];

            if(row<n && col<m){
                cnt = (cnt + dfs(row, col, grid, k, n, m, drow, dcol, sum+grid[row][col])) % MOD;
            }
        }

        dp[r][c][rem] = cnt;
        return cnt;
    }
    public int numberOfPaths(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        dp = new int[n][m][k];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int rem = 0; rem < k; rem++){
                    dp[i][j][rem] = -1;
                }
            }
        }

        int[] drow = {1, 0};
        int[] dcol = {0, 1};
        return dfs(0, 0, grid, k, n, m, drow, dcol, grid[0][0]);
    }
}