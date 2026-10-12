class Solution {
    public int resilientSubarray(int[] nums, int k) {
        int n = nums.length;

        int maxLen = 1;
        int l = 0;
        int r = 0;
        int rem = nums[0]%k;
        
        while(r < n){
            int remainder = nums[r]%k;
            if(remainder != rem){
                rem = remainder;
                l = r;
            }

            int len = r-l+1;
            if (((len - 1) * rem) % k == 0) {
                maxLen = Math.max(maxLen, len);
            }

            r++;
        }

        return maxLen;
    }
}