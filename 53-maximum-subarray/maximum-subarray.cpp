class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int MaxSum = INT_MIN;
        int Sum = 0;
        for(int i=0; i<nums.size(); i++){
            Sum += nums[i];
            if(Sum > MaxSum){
                MaxSum = Sum;
            }
            if(Sum < 0){
                Sum = 0;
            }
        }
        return MaxSum;
    }
};