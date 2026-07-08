class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;

        int l = 0;
        int r = 0;
        long cnt = 0;
        long sum = 0;

        while(r < n){
            
            sum += nums[r];

            long prod = sum * (r-l+1);
            while(prod >= k){ 
                sum -= nums[l];
                l++;
                prod = sum * (r-l+1);
            }

            if(prod < k){
                cnt += (r-l+1);
            }

            r++;
        }

        return cnt;
    }
}