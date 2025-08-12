class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        // int n = nums.size();
        // sort(nums.begin(), nums.end());
        // return nums[n-k];

        priority_queue<int> pq;
        for(auto it : nums){
            pq.push(it);
        }
        int ans;
        while(k--){
            ans = pq.top();
            pq.pop();
        }
        return ans;
    }
};