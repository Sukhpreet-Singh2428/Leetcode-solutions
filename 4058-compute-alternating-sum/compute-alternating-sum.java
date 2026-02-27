class Solution {
    public int alternatingSum(int[] nums) {
        int even = 0;
        int odd = 0;
        for(int i=0; i<nums.length; i++){
            if((i&1)==1){
                odd += nums[i];
            }
            else{
                even += nums[i];
            }
        }

        return even-odd;
    }
}