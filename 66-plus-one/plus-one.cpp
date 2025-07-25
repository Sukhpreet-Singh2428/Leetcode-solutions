class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        // long long num = 0;
        // for(auto it:digits){
        //     num = num*10 + it;
        // }
        // num = num + 1;
        // vector<int> result;
        // while(num>0){
        //     result.push_back(num%10);
        //     num /= 10;
        // }
        // reverse(result.begin(),result.end());
        // return result;

        int n = digits.size();
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        digits.insert(digits.begin(), 1);
        return digits;
    }
};