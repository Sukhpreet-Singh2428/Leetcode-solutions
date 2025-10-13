class Solution {
public:
    int specialArray(vector<int>& nums) {
        int n = nums.size();
        int ans = -1;
        sort(nums.begin(), nums.end());
        for(int x=1; x<=n; x++){
            int low = 0;
            int high = n-1;
            int idx = n;
            while(low<=high){
                int mid = low + (high-low)/2;
                if(nums[mid]>=x){
                    idx = mid;
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            int cnt = n-idx;
            if(x == cnt){
                return cnt;
            }
        }
        return ans;
    }
};