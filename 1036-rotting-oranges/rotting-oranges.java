class Pair{
    int row;
    int col;
    int time;

    public Pair(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> qu = new ArrayDeque<>();
        int[][] vis = new int[n][m];
        int cntFresh = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 2){
                    qu.offer(new Pair(i, j, 0));
                    vis[i][j] = 2;
                }
                else{
                    vis[i][j] = 0;
                }
                
                if(grid[i][j] == 1){
                    cntFresh++;
                }
            }
        }

        int tm = 0;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        int cnt = 0;
        while(!qu.isEmpty()){
            int r = qu.peek().row;
            int c = qu.peek().col;
            int t = qu.peek().time;
            tm = Math.max(tm, t);
            qu.poll();

            for(int i=0; i<4; i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                    qu.offer(new Pair(nrow, ncol, t+1));
                    vis[nrow][ncol] = 2;
                    cnt++;
                }
            }
        }

        if(cnt != cntFresh){
            return -1;
        }

        return tm;
    }
}