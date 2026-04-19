class Solution {
    public int func(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        int ans = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid] >= target){
                ans = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }
    public int maxDistance(int[] nums1, int[] nums2) {
        int ans = 0;

        for(int i=0; i<nums1.length; i++){
            int idx = func(nums2, nums1[i]);
            if(idx==-1) continue;
            if(i<=idx && nums1[i]<=nums2[idx]){
                ans = Math.max(ans, idx-i);
            }
        }

        return ans;   
    }
}