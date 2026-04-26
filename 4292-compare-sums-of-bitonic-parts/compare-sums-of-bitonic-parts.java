class Solution {
    public int peak(int[] nums){
        int n = nums.length; 

        if(n==1) return 0;
        if(nums[0]>nums[1]) return 0;
        if(nums[n-1]>nums[n-2]) return n-1;
        int low = 1;
        int high = n-2;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                return mid;
            }
            else if(nums[mid]>nums[mid-1]){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }
    public int compareBitonicSums(int[] nums) {
        int idx = peak(nums);

        long ascend = 0;
        long descend = 0;
        for(int i=0; i<=idx; i++){
            ascend += nums[i];
        }
        for(int i=idx; i<nums.length; i++){
            descend += nums[i];
        }

        if(ascend==descend) return -1;
        
        return ascend>descend ? 0 : 1;
    }
}