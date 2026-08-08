class Solution {
    int peri;
    public void dfs(int row, int col, int[][] grid, boolean[][] vis, int[] drow, int[] dcol, int n, int m){
        vis[row][col] = true;

        for(int i=0; i<4; i++){
            int nrow = row + drow[i];
            int ncol = col + dcol[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1){
                if(vis[nrow][ncol]==false){
                    dfs(nrow, ncol, grid, vis, drow, dcol, n, m);
                }
            }
            else{
                peri++;
            }
        }
    }
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        peri = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1 && vis[i][j]==false){
                    dfs(i, j, grid, vis, drow, dcol, n, m);
                    return peri;
                }
            }
        }

        return 0;
    }
}