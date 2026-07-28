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
        int cnt = 0;
        qu.offer(new Pair(row, col));
        vis[row][col] = true;
        cnt++;

        boolean[] rowDone = new boolean[n];
        boolean[] colDone = new boolean[m];

        while(!qu.isEmpty()){
            int r = qu.peek().row;
            int c = qu.peek().col;
            qu.poll();

            // same row
            if(rowDone[r]==false){
                rowDone[r] = true;
                for(int j=0; j<m; j++){
                    if(grid[r][j]==1 && vis[r][j]==false){
                        qu.offer(new Pair(r, j));
                        vis[r][j] = true;
                        cnt++;
                    }
                }
            }
            // same col
            if(colDone[c]==false){
                colDone[c] = true;
                for(int i=0; i<n; i++){
                    if(grid[i][c]==1 && vis[i][c]==false){
                        qu.offer(new Pair(i, c));
                        vis[i][c] = true;
                        cnt++;
                    }
                }
            }
        }

        if(cnt>1) return cnt;
        return 0;
    }
    public int countServers(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        int count = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1 && vis[i][j]==false){
                    count += bfs(i, j, vis, grid);
                }
            }
        }

        return count;
    }
}