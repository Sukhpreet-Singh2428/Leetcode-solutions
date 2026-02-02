class Solution {
    public static void subset(int idx, int sum, int[] nums, int n, int[] ans){
        if(idx==n){
            ans[0] += sum;
            return;
        }
        sum ^= nums[idx];
        subset(idx+1, sum, nums, n, ans);
        sum ^= nums[idx];
        subset(idx+1, sum, nums, n, ans);
    }
    public int subsetXORSum(int[] nums) {
        int[] ans = new int[1];
        subset(0, 0, nums, nums.length, ans);
        return ans[0];
    }
}