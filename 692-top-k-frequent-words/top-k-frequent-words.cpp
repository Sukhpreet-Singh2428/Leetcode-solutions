class Solution {
public:
    static bool compare(pair<string,int>& a, pair<string,int>& b){
        if(a.second==b.second) return a.first < b.first;
        return a.second > b.second;
    }
    vector<string> topKFrequent(vector<string>& words, int k) {
        unordered_map<string,int> mpp;
        for(auto it : words){
            mpp[it]++;
        }
        vector<pair<string,int>> v(mpp.begin(), mpp.end());
        sort(v.begin(), v.end(), compare);
        vector<string> ans;
        for(int i=0; i<k && i<v.size(); i++){
            ans.push_back(v[i].first);
        }
        return ans;
    }
};