class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        // With Sorting : 
        // unordered_map<string, vector<string>> mpp;
        // for(auto it : strs){
        //     string s = it;
        //     sort(s.begin(), s.end());
        //     mpp[s].push_back(it);
        // }
        // vector<vector<string>> ans;
        // for(auto it : mpp){
        //     ans.push_back(it.second);
        // }
        // return ans;

        unordered_map<string, vector<string>> mpp;
        for(auto it : strs){
            vector<int> count(26,0);
            for(auto c : it){
                count[c-'a']++;
            }
            string key = to_string(count[0]);
            for(int i=1; i<26; i++){
                key += ',' + to_string(count[i]);
            }
            mpp[key].push_back(it);
        }
        vector<vector<string>> ans;
        for(auto it : mpp){
            ans.push_back(it.second);
        }
        return ans;
    }
};