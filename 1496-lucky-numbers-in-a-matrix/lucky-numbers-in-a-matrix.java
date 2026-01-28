class Solution {
    public static boolean func(int val, int idx, int[][] matrix,int n){
        for(int i=0; i<n; i++){
            if(matrix[i][idx]>val) return false;
        }
        return true;
    }
    public static int minimum(int[] arr){
        int mini = Integer.MAX_VALUE;
        int idx = -1;
        for(int i=0; i<arr.length; i++){
            if(arr[i] < mini){
                mini = arr[i];
                idx = i;
            }
        }
        return idx;
    }
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<matrix.length; i++){
            int mini = minimum(matrix[i]);
            if(func(matrix[i][mini], mini, matrix,matrix.length)){
                ans.add(matrix[i][mini]);
            }
        }
        return ans;
    }
}