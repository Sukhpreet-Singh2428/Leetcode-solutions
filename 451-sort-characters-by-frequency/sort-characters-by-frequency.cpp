class Solution {
public:
    static bool compare(pair<char,int>& a, pair<char,int>& b){
        return a.second > b.second;
    }
    string frequencySort(string s) {
        string ans;
        unordered_map<char,int> mpp;
        for(auto it : s){
            mpp[it]++;
        }
        vector<pair<char,int>> v(mpp.begin(), mpp.end());
        sort(v.begin(), v.end(), compare);
        for(auto it : v){
            ans.append(it.second, it.first);    // .append(count, character)
        }
        return ans;
    }
};