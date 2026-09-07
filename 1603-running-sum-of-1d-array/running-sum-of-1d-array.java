class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int preSum = 0;
        for(int i=0; i<n; i++){
            preSum += nums[i];
            ans[i] = preSum;
        }

        return ans;
    }
}