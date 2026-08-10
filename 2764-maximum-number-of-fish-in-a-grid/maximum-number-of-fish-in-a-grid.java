class Pair{
    int row;
    int col;

    public Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int bfs(int row, int col, int[][] grid, boolean[][] vis){
        int n = grid.length;
        int m = grid[0].length;
        int sum = 0;

        Queue<Pair> qu = new ArrayDeque<>();
        qu.offer(new Pair(row, col));
        sum += grid[row][col];
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
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]>0 && vis[nrow][ncol]==false){
                    qu.offer(new Pair(nrow, ncol));
                    sum += grid[nrow][ncol];
                    vis[nrow][ncol]= true;
                }
            }
        }

        return sum;
    }
    public int findMaxFish(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        int ans = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]>0 && vis[i][j]==false){
                    int fishes = bfs(i, j, grid, vis);
                    ans = Math.max(ans, fishes);
                }
            }
        }

        return ans;
    }
}