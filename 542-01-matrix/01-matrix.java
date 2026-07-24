class Pair{
    int row;
    int col;
    int dist;

    public Pair(int row, int col, int dist){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        boolean[][] vis = new boolean[n][m];
        Queue<Pair> qu = new ArrayDeque<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j]==0){
                    qu.offer(new Pair(i, j, 0));
                    vis[i][j] = true;
                }
                else{
                    vis[i][j] = false;
                }
            }
        }

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        while(!qu.isEmpty()){
            int r = qu.peek().row;
            int c = qu.peek().col;
            int steps = qu.peek().dist;
            mat[r][c] = steps;
            qu.poll();

            for(int i=0; i<4; i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==false){
                    vis[nrow][ncol] = true;
                    qu.offer(new Pair(nrow, ncol, steps+1));
                }
            }
        }

        return mat;
    }
}