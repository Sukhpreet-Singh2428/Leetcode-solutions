class Pair {
    int row;
    int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public void bfs(int n, int m, int[][] grid, boolean[][] vis, int[][] ans, int[][] sources) {
        Queue<Pair> qu = new ArrayDeque<>();

        // Push sources in descending color order
        for (int[] s : sources) {
            qu.offer(new Pair(s[0], s[1]));
            vis[s[0]][s[1]] = true;
        }

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while (!qu.isEmpty()) {
            Pair cur = qu.poll();

            int r = cur.row;
            int c = cur.col;
            int color = ans[r][c];

            for (int i = 0; i < 4; i++) {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                        && !vis[nrow][ncol] && grid[nrow][ncol] == 0) {

                    vis[nrow][ncol] = true;
                    ans[nrow][ncol] = color;
                    qu.offer(new Pair(nrow, ncol));
                }
            }
        }
    }
    public int[][] colorGrid(int n, int m, int[][] sources) {
        // Sort by color descending
        Arrays.sort(sources, (a, b) -> b[2] - a[2]);

        int[][] grid = new int[n][m];

        for (int[] s : sources) {
            grid[s[0]][s[1]] = s[2];
        }

        boolean[][] vis = new boolean[n][m];
        int[][] ans = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = grid[i][j];
            }
        }

        bfs(n, m, grid, vis, ans, sources);

        return ans;
    }
}