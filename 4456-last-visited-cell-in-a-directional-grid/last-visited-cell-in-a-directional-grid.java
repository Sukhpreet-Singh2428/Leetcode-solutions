class Solution {
    public boolean func(int r, int c, char[][] grid, int[] ans, boolean[][] vis, int n, int m){
        if(r<0 || r>=n || c<0 || c>=m){
            return true;
        }
        if(vis[r][c] == true){
            return true;
        }
        
        vis[r][c] = true;
        ans[0] = r;
        ans[1] = c;
        char ch = grid[r][c];
        if(ch=='L'){
            c = c-1;
        }
        else if(ch=='R'){
            c = c+1;
        }
        else if(ch=='U'){
            r = r-1;
        }
        else if(ch=='D'){
            r = r+1;
        }

        if(func(r, c, grid, ans, vis, n, m) == true){
            return true;
        }

        return false;
    }
    public int[] lastVisitedCell(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        int[] ans = new int[2];

        func(0, 0, grid, ans, vis, n, m);

        return ans;
    }
}