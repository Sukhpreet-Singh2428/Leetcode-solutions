class Pair{
    int row;
    int col;

    public Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public void bfs(int row, int col, int[][] ans, int[][] image, int iniColor, int newColor){
        int n = image.length;
        int m = image[0].length;

        Queue<Pair> qu = new ArrayDeque<>();
        qu.offer(new Pair(row, col));
        ans[row][col] = newColor;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while(!qu.isEmpty()){
            int r = qu.peek().row;
            int c = qu.peek().col;
            qu.poll();

            for(int i=0; i<4; i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && ans[nrow][ncol]!=newColor && image[nrow][ncol]==iniColor){
                    qu.offer(new Pair(nrow, ncol));
                    ans[nrow][ncol] = newColor;
                }
            }
        }

    }
    public void dfs(int row, int col, int[][] ans, int[][] image, int iniColor, int newColor, int[] drow, int[] dcol){
        ans[row][col] = newColor;

        int n = image.length;
        int m = image[0].length;
        for(int i=0; i<4; i++){
            int nrow = row + drow[i];
            int ncol = col + dcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && ans[nrow][ncol]!=newColor && image[nrow][ncol]==iniColor){
                dfs(nrow, ncol, ans, image, iniColor, newColor, drow, dcol);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        int iniColor = image[sr][sc];
        int[][] ans = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                ans[i][j] = image[i][j];
            }
        }

        // bfs(sr, sc, ans, image, iniColor, color);
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        dfs(sr, sc, ans, image, iniColor, color, drow, dcol);

        return ans;
    }
}