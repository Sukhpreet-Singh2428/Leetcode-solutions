class Solution {
public:
    // bool palindrome(string& s){
    //     int left = 0;
    //     int right = s.size()-1;
    //     while(left<right){
    //         if(s[left] != s[right]) return false;
    //         left++;
    //         right--;
    //     }
    //     return true;
    // }
    bool palindrome(const string& s, int left, int right) {
        while (left < right) {
            if (s[left++] != s[right--])
                return false;
        }
        return true;
    }
    vector<vector<int>> palindromePairs(vector<string>& words) {
        // int n = words.size();
        // vector<vector<int>> ans;
        // for(int i=0; i<n; i++){
        //     for(int j=0; j<n; j++){
        //         if(i==j) continue;
        //         string s = words[i] + words[j];
        //         if(palindrome(s)){
        //             ans.push_back({i,j});
        //         }
        //     }
        // }
        // return ans;

        unordered_map<string, int> mpp;
        vector<vector<int>> ans;

        for(int i=0; i<words.size(); i++){
            string s = words[i];
            reverse(s.begin(), s.end());
            mpp[s] = i;
        }

        for(int i=0; i<words.size(); i++){
            string word = words[i];
            int len = word.size();

            for(int j=0; j<=len; j++){
                string left = word.substr(0,j);
                string right = word.substr(j);

                // // Case 1: If left is palindrome, check for reversed right
                if(palindrome(word, 0, j-1)){
                    if(mpp.find(right) != mpp.end() && mpp[right] != i){
                        ans.push_back({mpp[right], i});
                    }
                }
                    // Case 2: If right is palindrome, check for reversed left
                // j != len avoids duplicate pairs when left and right both are empty

                if(j != len && palindrome(word, j, len-1)){
                    if(mpp.find(left) != mpp.end() && mpp[left] != i){
                        ans.push_back({i, mpp[left]});
                    }
                }
            }
        }
        return ans;
    }
};