class Pair{
    int row;
    int col;

    public Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public void dfs(int row, int col, boolean[][] vis, int[][] grid, int[] drow, int[] dcol){
        vis[row][col] = true;

        int n = grid.length;
        int m = grid[0].length;
        for(int i=0; i<4; i++){
            int nrow = row + drow[i];
            int ncol = col + dcol[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==false && grid[nrow][ncol]==0){
                dfs(nrow, ncol, vis, grid, drow, dcol);
            }
        }
    }
    public void bfs(int row, int col, boolean[][] vis, int[][] grid, int[] drow, int[] dcol){
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> qu = new ArrayDeque<>();
        qu.offer(new Pair(row, col));
        vis[row][col] = true;

        while(!qu.isEmpty()){
            int r = qu.peek().row;
            int c = qu.peek().col;
            qu.poll();

            for(int i=0; i<4; i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==false && grid[nrow][ncol]==0){
                    qu.offer(new Pair(nrow, ncol));
                    vis[nrow][ncol] = true;
                }
            }
        }
    }
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        // first row and last row
        for(int j=0; j<m; j++){
            if(grid[0][j]==0 && vis[0][j]==false){
                dfs(0, j, vis, grid, drow, dcol);
            }
            if(grid[n-1][j]==0 && vis[n-1][j]==false){
                dfs(n-1, j, vis, grid, drow, dcol);
            }
        }
        // first col and last col
        for(int i=0; i<n; i++){
            if(grid[i][0]==0 && vis[i][0]==false){
                dfs(i, 0, vis, grid, drow, dcol);
            }
            if(grid[i][m-1]==0 && vis[i][m-1]==false){
                dfs(i, m-1, vis, grid, drow, dcol);
            }
        }

        int cnt = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(vis[i][j]==false && grid[i][j]==0){
                    cnt++;
                    bfs(i, j, vis, grid, drow, dcol);
                }
            }
        }

        return cnt;
    }
}