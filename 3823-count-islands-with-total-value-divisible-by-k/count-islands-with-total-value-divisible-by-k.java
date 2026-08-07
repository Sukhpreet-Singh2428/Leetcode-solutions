class Pair{
    int row;
    int col;

    public Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public boolean bfs(int row, int col, boolean[][] vis, int[][] grid, int k){
        int n = grid.length;
        int m = grid[0].length;
        long sum = 0;

        Queue<Pair> qu = new ArrayDeque<>();
        qu.offer(new Pair(row, col));
        vis[row][col] = true;
        sum += grid[row][col];

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while(!qu.isEmpty()){
            int r = qu.peek().row;
            int c = qu.peek().col;
            qu.poll();
            
            for(int i=0; i<4; i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==false && grid[nrow][ncol]!=0){
                    qu.offer(new Pair(nrow, ncol));
                    vis[nrow][ncol] = true;
                    sum += grid[nrow][ncol];
                }
            }
        }

        return sum%k==0 ? true : false;
    }
    public int countIslands(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        int cnt = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(vis[i][j]==false && grid[i][j] != 0){
                    if(bfs(i, j, vis, grid, k)){
                        cnt++;    
                    }
                }
            }
        }

        return cnt;
    }
}