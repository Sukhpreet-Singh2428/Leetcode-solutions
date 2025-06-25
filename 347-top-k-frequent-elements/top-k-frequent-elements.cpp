class Solution {
public:
    static bool compare(pair<int,int>& a, pair<int,int>& b){
        return a.second>b.second;
    }
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int, int> mpp;
        for(auto it : nums){
            mpp[it]++;
        }
        vector<pair<int,int>> freqV;
        for(auto it : mpp){
            freqV.push_back({it.first, it.second});
        }
        sort(freqV.begin(), freqV.end(), compare);
        vector<int> ans;
        for(int i=0; i<k && i<nums.size(); i++){
            ans.push_back(freqV[i].first);
        }
        return ans;
    }
};