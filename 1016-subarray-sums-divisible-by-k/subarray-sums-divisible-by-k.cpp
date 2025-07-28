class Solution {
public:
    int subarraysDivByK(vector<int>& nums, int k) {
        // int n = nums.size();
        // int cnt = 0;
        // for(int i=0; i<n; i++){
        //     int sum = 0;
        //     for(int j=i; j<n; j++){
        //         sum += nums[j];
        //         if(sum%k==0) cnt++;
        //     }
        // }
        // return cnt;
        int n = nums.size();
        unordered_map<int, int> mpp;
        mpp[0] = 1;
        int preSum = 0;
        int cnt = 0;
        for(int i=0; i<n; i++){
            preSum += nums[i];
            int remove = preSum%k;
            if(remove<0) remove += k;
            if(mpp.find(remove) != mpp.end()){
                cnt += mpp[remove];
            }
            mpp[remove] += 1;
        }
        return cnt;
    }
};