class Solution {
    public static void func(int idx, int prev, int sum, int n, int target, int[] nums, int[] cnt){
        if(idx==n){
            if(sum==target){
                cnt[0]++;
            }
            return;
        }

        prev = sum;
        sum += nums[idx];
        func(idx+1, prev, sum, n, target, nums, cnt);
        sum = prev;
        sum -= nums[idx];
        func(idx+1, prev, sum, n, target, nums, cnt);
    }
    public int findTargetSumWays(int[] nums, int target) {
        int[] cnt = new int[1];

        func(0, 0, 0, nums.length, target, nums, cnt);

        return cnt[0];
    }
}