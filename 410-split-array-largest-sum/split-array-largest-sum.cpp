class Solution {
public:
    int func(vector<int>& nums, int maxSum){
        int n = nums.size();
        int partitions = 1;
        int sum = 0;
        for(int i=0; i<n; i++){
            if((nums[i] + sum) <= maxSum){
                sum += nums[i];
            }
            else{
                partitions++;
                sum = nums[i];
            }
        }
        return partitions;
    }
    int splitArray(vector<int>& nums, int k) {
        int n = nums.size();
        int sum = 0;
        for(auto it : nums){
            sum += it;
        }
        int low = *max_element(nums.begin(), nums.end());
        int high = sum;
        int ans = high;
        while(low<=high){
            int mid = low + (high-low)/2;
            int noOfSubarray = func(nums, mid);
            if(noOfSubarray > k){
                low = mid+1;
            }
            else{
                ans = mid;
                high = mid-1;
            }
        }
        return ans;
    }
};