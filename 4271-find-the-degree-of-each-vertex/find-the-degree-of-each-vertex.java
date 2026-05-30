class Solution {
    public int[] findDegrees(int[][] matrix) {
        int[] ans = new int[matrix.length];
        
        for(int i=0; i<matrix.length; i++){
            int sum = 0;
            for(int x : matrix[i]){
                sum += x;
            }
            ans[i] = sum;
        }

        return ans;
    }
}