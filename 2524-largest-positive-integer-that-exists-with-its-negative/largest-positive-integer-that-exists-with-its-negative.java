class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        int j = nums.length-1;
        while(i<j){
            int val = -1 * nums[i];
            if(val==nums[j]){
                return nums[j];
            }
            else if(val < nums[j]){
                j--;
            }
            else{
                i++;
            }
        }

        return -1;
    }
}