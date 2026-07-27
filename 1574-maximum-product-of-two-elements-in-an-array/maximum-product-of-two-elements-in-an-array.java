class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxi = -1;
        int smaxi = -1;

        for(int i=0; i<n; i++){
            if(nums[i] > maxi){
                smaxi = maxi;
                maxi = nums[i];
            }
            else if(nums[i] == maxi){
                smaxi = nums[i];
            }
            else if(nums[i] > smaxi && nums[i] != maxi){
                smaxi = nums[i];
            }
        }

        int ans = (maxi-1)*(smaxi-1);

        return ans;
    }
}