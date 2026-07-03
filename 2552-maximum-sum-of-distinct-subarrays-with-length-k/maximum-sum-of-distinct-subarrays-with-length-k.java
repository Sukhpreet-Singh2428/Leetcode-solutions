class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;

        int l = 0;
        int r = 0;
        long maxSum = 0;
        long sum = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();

        while(r < n){
            while(mp.containsKey(nums[r]) && mp.get(nums[r]) >= l){
                sum -= nums[l];
                l++;
            }

            sum += nums[r];
            mp.put(nums[r], r);

            if(r-l+1 > k){
                sum -= nums[l];
                l++;
            }

            if(r-l+1 == k){
                maxSum = Math.max(maxSum, sum);
            }

            r++;
        }

        return maxSum;
    }
}