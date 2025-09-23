class Solution {
public:
    int maxFrequencyElements(vector<int>& nums) {
        int n = nums.size();
        unordered_map<int, int> mpp;
        for(int i=0; i<n; i++){
            mpp[nums[i]]++;
        }
        int maxf = -1;
        for(auto it : mpp){
            if(it.second>maxf){
                maxf = it.second;
            }
        }
        int cnt = 0;
        for(auto it : mpp){
            if(maxf == it.second){
                cnt += it.second;
            }
        }
        return cnt;
    }
};