class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        unordered_set<int> set;
        for(auto it : nums1){
            set.insert(it);
        }
        vector<int> ans;

        for(auto it : nums2){
            if(set.erase(it)) ans.push_back(it);
        }
        return ans;
    }
};