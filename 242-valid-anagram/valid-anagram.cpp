class Solution {
public:
    bool isAnagram(string s, string t) {
        if(s.size()!=t.size()) return false;
        unordered_map<char, int> mpp1;
        unordered_map<char, int> mpp2;
        for(auto it : s){
            mpp1[it]++;
        }
        for(auto it : t){
            mpp2[it]++;
        }
       if(mpp1==mpp2) return true;
       return false;
    }
};