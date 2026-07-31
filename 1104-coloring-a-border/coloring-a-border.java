class Pair {
    int row;
    int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public void bfs(int sr, int sc, boolean[][] vis, int[][] grid, int[][] ans, int color) {
        int n = grid.length;
        int m = grid[0].length;
        int original = grid[sr][sc];

        Queue<Pair> qu = new ArrayDeque<>();
        qu.offer(new Pair(sr, sc));
        vis[sr][sc] = true;

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while (!qu.isEmpty()) {
            int r = qu.peek().row;
            int c = qu.peek().col;
            qu.poll();

            int cnt = 0;
            for(int i = 0; i < 4; i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == original){
                    cnt++;

                    if (!vis[nrow][ncol]) {
                        vis[nrow][ncol] = true;
                        qu.offer(new Pair(nrow, ncol));
                    }
                }
            }

            if (cnt != 4) {
                ans[r][c] = color;
            }
        }
    }
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] ans = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j=0; j<m; j++){
                ans[i][j] = grid[i][j];
            }
        }

        boolean[][] vis = new boolean[n][m];

        bfs(row, col, vis, grid, ans, color);

        return ans;
    }
}