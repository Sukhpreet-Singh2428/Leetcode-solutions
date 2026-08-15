class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;

        int l = 0;
        int r = 0;
        int maxLen = 0;
        int last = -1;

        while(r<n){
            if(last!=-1 && nums[r]<=last){
                l = r;
            }

            last = nums[r];

            maxLen = Math.max(maxLen, r-l+1);

            r++;
        }

        return maxLen;
    }
}