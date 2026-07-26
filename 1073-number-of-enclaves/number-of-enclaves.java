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
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==false && grid[nrow][ncol]==1){
                dfs(nrow, ncol, vis, grid, drow, dcol);
            }
        }
    }
    public void bfs(int row, int col, boolean[][] vis, int[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> qu = new ArrayDeque<>();
        qu.offer(new Pair(row, col));
        vis[row][col] = true;

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while(!qu.isEmpty()){
            int r = qu.peek().row;
            int c = qu.peek().col;
            qu.poll();

            for(int i=0; i<4; i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==false && grid[nrow][ncol]==1){
                    vis[nrow][ncol] = true;
                    qu.offer(new Pair(nrow, ncol));
                }
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        boolean[][] vis = new boolean[n][m];

        // int[] drow = {-1, 0, 1, 0};
        // int[] dcol = {0, 1, 0, -1};

        // first row and last row
        for(int j=0; j<m; j++){
            if(grid[0][j]==1 && vis[0][j]==false){
                // dfs(0, j, vis, grid, drow, dcol);
                bfs(0, j, vis, grid);
            }
            if(grid[n-1][j]==1 && vis[n-1][j]==false){
                // dfs(n-1, j, vis, grid, drow, dcol);
                bfs(n-1, j, vis, grid);
            }
        }

        // first col and last col
        for(int i=0; i<n; i++){
            if(grid[i][0]==1 && vis[i][0]==false){
                // dfs(i, 0, vis, grid, drow, dcol);
                bfs(i, 0, vis, grid);
            }
            if(grid[i][m-1]==1 && vis[i][m-1]==false){
                // dfs(i, m-1, vis, grid, drow, dcol);
                bfs(i, m-1, vis, grid);
            }
        }

        int cnt = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(vis[i][j]==false && grid[i][j]==1){
                    cnt++;
                }
            }
        }

        return cnt;
    }
}