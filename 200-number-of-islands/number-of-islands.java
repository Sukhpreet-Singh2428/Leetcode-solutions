class Solution {
    public void dfs(int row, int col, boolean[][] vis, char[][] grid, int[] drow, int[] dcol){
        vis[row][col] = true;

        int n = grid.length;
        int m = grid[0].length;
        for(int i=0; i<4; i++){
            int nrow = row + drow[i];
            int ncol = col + dcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==false && grid[nrow][ncol]=='1'){
                dfs(nrow, ncol, vis, grid, drow, dcol);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        int cnt = 0;

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(vis[i][j]==false && grid[i][j]=='1'){
                    cnt++;
                    dfs(i, j, vis, grid, drow, dcol);
                }
            }
        }

        return cnt;
    }
}