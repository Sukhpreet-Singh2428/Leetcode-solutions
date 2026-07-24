class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] onesRow = new int[n];
        int[] onesCol = new int[m];

        for(int i=0; i<n; i++){
            int one = 0;
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){
                    one++;
                }
            }
            onesRow[i] = one;
        }

        for(int j=0; j<m; j++){
            int one = 0;
            for(int i=0; i<n; i++){
                if(grid[i][j]==1){
                    one++;
                }
            }
            onesCol[j] = one;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                grid[i][j] = onesRow[i] + onesCol[j] - (n - onesRow[i]) - (m - onesCol[j]);
            }
        }

        return grid;
    }
}