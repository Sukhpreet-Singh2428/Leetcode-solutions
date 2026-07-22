class Pair{
    int row;
    int col;

    public Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int bfs(int row, int col, boolean[][] vis, int[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> qu = new ArrayDeque<>();
        qu.offer(new Pair(row, col));
        vis[row][col] = true;
        int area = 0;

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        while(!qu.isEmpty()){
            int r = qu.peek().row;
            int c = qu.peek().col;
            qu.poll();
            area++;

            for(int i=0; i<4; i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==false && grid[nrow][ncol]==1){
                    qu.offer(new Pair(nrow, ncol));
                    vis[nrow][ncol] = true;
                }
            }
        }

        return area;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        int maxArea = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(vis[i][j]==false && grid[i][j]==1){
                    int area = bfs(i, j, vis, grid);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }
}