class Solution {
public:
    int sumOddLengthSubarrays(vector<int>& arr) {
        int n = arr.size();
        vector<int> ans;
        for(int i=0; i<n; i++){
            int sum = 0, cnt = 0;
            for(int j=i; j<n; j++){
                sum += arr[j];
                cnt++;
                if(cnt%2!=0) ans.push_back(sum);
            }
        }
        int total = 0;
        for(auto it : ans) total += it;
        return total;
    }
};