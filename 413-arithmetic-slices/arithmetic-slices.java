class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if(n<3) return 0;

        int l = 0;
        int r = 1;
        int cnt = 0;
        int diff = nums[1]-nums[0];

        while(r < n){
            if(nums[r]-nums[r-1]!=diff){
                l = r-1;
                diff = nums[r] - nums[r-1];
            }
            else if(r-l+1 >= 3){
                cnt += (r-l+1)-2;
            }

            r++;
        }

        return cnt;
    }
}