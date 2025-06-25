class Solution {
public:
    bool isIsomorphic(string s, string t) {
        if(s.size() != t.size()) return false;
        unordered_map<char, char> m1;
        unordered_map<char, char> m2;
        for(int i = 0; i < s.size(); i++) {
            char a = s[i];
            char b = t[i];
            // Check mapping from s to t
            if(m1.count(a)) {              // <-- .count(key) checks if a key exists in the map.
                if(m1[a] != b) return false;
            } else {
                m1[a] = b;
            }
            // Check reverse mapping from t to s
            if(m2.count(b)) {
                if(m2[b] != a) return false;
            } else {
                m2[b] = a;
            }
        }
        return true;
    }
};