class Solution {
    public int countSubarrayWithSumLessThanEqualToK(int[] nums, int k){
        if(k<0) return 0;
        int n = nums.length;

        int l = 0;
        int r = 0;
        int cnt = 0;
        int sum = 0;

        while(r < n){
            sum += nums[r];

            while(sum > k){
                sum -= nums[l];
                l++;
            }

            if(sum<=k){
                cnt = cnt + r-l+1;
            }

            r++;
        }

        return cnt;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        for(int i=0; i<nums.length; i++){
            nums[i] = nums[i]%2;
        }

        // now problem become, binary subarrays with sum

        return countSubarrayWithSumLessThanEqualToK(nums, k) - countSubarrayWithSumLessThanEqualToK(nums, k-1);
    }
}