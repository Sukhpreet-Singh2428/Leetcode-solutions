class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;

        int l = 0;
        int r = 0;
        int maxLen = 0;
        int zero = 0;

        while(r < n){
            if(nums[r]==0) zero++;

            while(zero > 1){
                if(nums[l]==0) zero--;
                l++;
            }

            int len = r-l+1;
            maxLen = Math.max(maxLen, len-1);  //? excluding the zero that needs to delete

            r++;
        }

        return maxLen;
    }
}