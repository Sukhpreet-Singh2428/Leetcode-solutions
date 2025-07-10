class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        unordered_map<int, int> mpp1, mpp2;
        for(auto it : nums1) mpp1[it]++;
        for(auto it : nums2) mpp2[it]++; 
        vector<int> ans;
        for(auto it : mpp1){
            if(mpp2.count(it.first)){
                int cnt = min(it.second, mpp2[it.first]);
                for(int i=0; i<cnt; i++){
                    ans.push_back(it.first);
                }
            }
        }
        return ans;
    }
};