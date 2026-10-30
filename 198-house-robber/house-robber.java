class Solution {
    public int func(int idx, int[] nums, int[] dp){
        if(idx>=nums.length){
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }

        int rob = nums[idx] + func(idx+2, nums, dp);
        int skip = func(idx+1, nums, dp);

        return dp[idx] = Math.max(rob, skip);
    }
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return func(0, nums, dp);
    }
}