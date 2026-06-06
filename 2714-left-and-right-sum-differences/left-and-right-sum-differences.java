class Solution {
    public int[] leftRightDifference(int[] nums) {
        int left = 0;
        int[] leftSum = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            leftSum[i] = left;
            left += nums[i];
        }

        int right = 0;
        int[] rightSum = new int[nums.length];

        for(int i=nums.length-1; i>=0; i--){
            rightSum[i] = right;
            right += nums[i];
        }        

        int[] ans = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            ans[i] = Math.abs(leftSum[i] - rightSum[i]);
        }

        return ans;
    }
}