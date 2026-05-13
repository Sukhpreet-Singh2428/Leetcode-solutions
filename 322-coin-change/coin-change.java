class Solution {
    public int func(int sum, int[] coins, int amount, int[] dp){
        if(sum==amount){
            return 0;
        }
        if(sum>amount){
            return Integer.MAX_VALUE;
        }
        if(dp[sum] != -1){
            return dp[sum];
        }

        int mini = Integer.MAX_VALUE;
        for(int i=0; i<coins.length; i++){
            if(sum <= amount - coins[i]){
                int take = func(sum + coins[i], coins, amount, dp);
                if(take != Integer.MAX_VALUE){
                    mini = Math.min(mini, 1 + take);
                }
            }
        }
        dp[sum] = mini;

        return dp[sum];
    }
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);

        int ans = func(0, coins, amount, dp);

        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
}