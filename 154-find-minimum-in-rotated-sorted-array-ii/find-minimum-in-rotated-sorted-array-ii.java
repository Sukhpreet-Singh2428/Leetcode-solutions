class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        Integer mini = Integer.MAX_VALUE;
        if(n==1) return nums[0];
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[low]==nums[mid] && nums[mid]==nums[high]){
                mini = Math.min(mini, nums[low]);
                low++;
                high--;
                continue;
            }
            if(nums[low]<=nums[mid]){
                mini = Math.min(mini, nums[low]);
                low = mid+1;
            }
            else{
                mini = Math.min(mini, nums[mid]);
                high = mid-1;
            }
        }
        return mini;
    }
}