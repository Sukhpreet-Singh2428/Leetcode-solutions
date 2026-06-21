class Solution {
    public int func(int r, int c, int[][] matrix, int[][] dp){
        if(r<0 || r>=matrix.length){
            return 0;
        }
        if(c<0 || c>=matrix[0].length){
            return 0;
        }

        if(dp[r][c] != 0){
            return dp[r][c];
        }
        
        int best = 1;
        // up
        if(r>0 && matrix[r-1][c] < matrix[r][c]) best = Math.max(best, 1 + func(r-1, c, matrix, dp));
        // down
        if(r+1<matrix.length && matrix[r+1][c] < matrix[r][c]) best = Math.max(best, 1 + func(r+1, c, matrix, dp));
        // left
        if(c>0 && matrix[r][c-1] < matrix[r][c]) best = Math.max(best, 1 + func(r, c-1, matrix, dp));
        // right
        if(c+1<matrix[0].length && matrix[r][c+1] < matrix[r][c]) best = Math.max(best, 1 + func(r, c+1, matrix, dp));

        dp[r][c] = best;
        return best;

    }
    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];

        int ans = 0;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                ans = Math.max(ans, func(i, j, matrix, dp));
            }
        }

        return ans;
    }
}