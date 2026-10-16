class Solution {
    int cnt;
    public void dfs(int r, int c, int er, int ec, int[][] grid, int needCover, int[] drow, int[] dcol, boolean[][] vis, int cover, int n, int m){
        if(r==er && c==ec){
            if(cover == needCover){
                cnt++;
            }
            return;
        }

        vis[r][c] = true;
        for(int i=0; i<4; i++){
            int row = r + drow[i];
            int col = c + dcol[i];

            if(row>=0 && row<n && col>=0 && col<m && grid[row][col]!=-1 && vis[row][col]==false){
                dfs(row, col, er, ec, grid, needCover, drow, dcol, vis, cover+1, n, m);
            }
        }

        vis[r][c] = false;
    }
    public int uniquePathsIII(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int r = 0;
        int c = 0;
        int er = 0;
        int ec = 0;
        int needCover = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] != -1){
                    needCover++;
                }
                if(grid[i][j] == 1){
                    r = i;
                    c = j;
                }
                else if(grid[i][j] == 2){
                    er = i;
                    ec = j;
                }
            }
        }

        cnt = 0;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        boolean[][] vis = new boolean[n][m];
        dfs(r, c, er, ec, grid, needCover, drow, dcol, vis, 1, n, m);

        return cnt;
    }
}