class Solution {
public:
    void reverseString(vector<char>& s) {
        // reverse(s.begin(),s.end());  <-- from STL
        int i = 0;
        int j = s.size() - 1;
        while(i<=j){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
};