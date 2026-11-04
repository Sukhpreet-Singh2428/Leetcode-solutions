class Solution {
    public int func(int idx, int prev, int n, int[] nums, int[][] dp){
        if(idx==n){
            return 0;
        }
        if(dp[idx][prev+1] != -1){
            return dp[idx][prev+1];
        }

        int pick = 0;
        if(prev==-1 || nums[prev] < nums[idx]){
            pick = 1 + func(idx+1, idx, n, nums, dp);
        }

        int skip = func(idx+1, prev, n, nums, dp);

        return dp[idx][prev+1] = Math.max(pick, skip);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        
        int[][] dp = new int[n][n+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        
        int prev = -1;

        return func(0, prev, n, nums, dp);
    }
}