class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        // unordered_map<int, int> mpp;
        // int n = numbers.size();
        // for(int i=0; i<n; i++){
        //     int diff = target - numbers[i];
        //     if(mpp.count(diff)){
        //         return {mpp[diff]+1, i+1};
        //     }
        //     mpp[numbers[i]] = i;
        // }
        // return {};

        int left = 0;
        int right = numbers.size()-1;
        while(left<right){
            int sum = numbers[left] + numbers[right];
            if(sum==target) return {left+1, right+1};
            else if(sum<target) left++;
            else right--;
        }
        return {};
    }
};