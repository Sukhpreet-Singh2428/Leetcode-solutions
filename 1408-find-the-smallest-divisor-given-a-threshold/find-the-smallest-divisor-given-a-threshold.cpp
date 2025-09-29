class Solution {
public:
    long long sumOfDivisions(vector<int>& nums, int divisor){
        int n = nums.size();
        long long sum = 0;
        for(int i=0; i<n; i++){
            sum += ceil( (double)nums[i]/(double)divisor);
        }
        return sum;
    }
    int smallestDivisor(vector<int>& nums, int threshold) {
        int n = nums.size();

        int low = 1;
        int high = *max_element(nums.begin(), nums.end());
        int ans = high;
        while(low<=high){
            int mid = low + (high-low)/2;
            long long sum = sumOfDivisions(nums, mid);
            if(sum <= threshold){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
};