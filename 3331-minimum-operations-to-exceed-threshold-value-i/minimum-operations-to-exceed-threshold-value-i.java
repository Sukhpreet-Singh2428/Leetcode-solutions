class Solution {
    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums.length;
        int ans = -1;

        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid] >= k){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return ans;
    }
}