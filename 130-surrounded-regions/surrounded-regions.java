class Solution {
    public void dfs(int row, int col, boolean[][] vis, char[][] board, int[] drow, int[] dcol){
        vis[row][col] = true;

        int n = board.length;
        int m = board[0].length;
        for(int i=0; i<4; i++){
            int nrow = row + drow[i];
            int ncol = col + dcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==false && board[nrow][ncol]=='O'){
                dfs(nrow, ncol, vis, board, drow, dcol);
            }
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        
        boolean[][] vis = new boolean[n][m];

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        // first row and last row
        for(int j=0; j<m; j++){
            if(board[0][j]=='O' && vis[0][j]==false){
                dfs(0, j, vis, board, drow, dcol);
            }
            if(board[n-1][j]=='O' && vis[n-1][j]==false){
                dfs(n-1, j, vis, board, drow, dcol);
            }
        }

        // first col and last col
        for(int i=0; i<n; i++){
            if(board[i][0]=='O' && vis[i][0]==false){
                dfs(i, 0, vis, board, drow, dcol);
            }
            if(board[i][m-1]=='O' && vis[i][m-1]==false){
                dfs(i, m-1, vis, board, drow, dcol);
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(vis[i][j]==false && board[i][j]=='O'){
                    board[i][j] = 'X';
                }
            }
        }

    }
}