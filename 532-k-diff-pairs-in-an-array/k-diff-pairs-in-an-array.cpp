class Solution {
public:
    int findPairs(vector<int>& nums, int k) {
        unordered_map<int, int> mpp;
        for(auto it : nums){
            mpp[it]++;
        }
        int cnt = 0;
        for(auto it : mpp){
            if(k==0){
                if(it.second>1) cnt++;
            }
            else if(mpp.count(it.first+k)) cnt++;
        }
        return cnt;
    }
};