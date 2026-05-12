class Solution {
    public static void func(int i, int j, int r, int c, int[][] mat, int dis, int[] mini, boolean[][] visited){
        if(i<0 || i>=r || j<0 || j>=c){
            return;
        }
        if(visited[i][j] == true){
            return;
        }
        if(mat[i][j] == 0){
            mini[0] = Math.min(mini[0], dis);
            return;
        }
        if(dis >= mini[0]){
            return;
        }

        visited[i][j] = true;
        // up
        func(i-1, j, r, c, mat, dis+1, mini, visited);

        // down
        func(i+1, j, r, c, mat, dis+1, mini, visited);

        // left
        func(i, j-1, r, c, mat, dis+1, mini, visited);

        // right 
        func(i, j+1, r, c, mat, dis+1, mini, visited);

        visited[i][j] = false;
        
    }
    public int[][] updateMatrix(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        int[][] ans = new int[r][c];
        boolean[][] visited = new boolean[r][c];

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(mat[i][j] == 1){
                    int[] mini = new int[1];
                    mini[0] = Integer.MAX_VALUE;
                    func(i, j, r, c, mat, 0, mini, visited);
                    ans[i][j] = mini[0];
                }
            }
        }

        return ans;
    }
}