class Solution {
public:
    bool isAnagram(string s, string t) {
        if(s.size()!=t.size()) return false;
        int hash[256] = {0};
        for(auto it : s){
            hash[it]++;
        }
        for(auto it : t){
            hash[it]--;
        }
        for(int i=0;i<256;i++){
            if(hash[i] != 0) return false;
        }
        return true;
    }
};