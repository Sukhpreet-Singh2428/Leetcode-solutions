class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        // int n = nums.size();
        // set<vector<int>> st;
        // for(int i=0; i<n-1; i++){
        //     set<int> temp;
        //     for(int j=i+1; j<n; j++){
        //         int third = -(nums[i] + nums[j]);
        //         if(temp.find(third) != temp.end()){
        //             vector<int> v = {nums[i], nums[j], third};
        //             sort(v.begin(), v.end());
        //             st.insert(v);
        //         }
        //         temp.insert(nums[j]);
        //     }
        // }
        // vector<vector<int>> ans(st.begin(), st.end());
        // return ans;

        int n = nums.size();
        vector<vector<int>> ans;
        sort(nums.begin(), nums.end());
        for(int i=0; i<n; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;

            int j = i+1;
            int k = n-1;

            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum<0) j++;
                else if(sum>0) k--;
                else{
                    vector<int> temp = {nums[i], nums[j], nums[k]};
                    ans.push_back(temp);
                    j++;
                    k--;
                    while(j<k && nums[j]==nums[j-1]) j++;
                    while(j<k && nums[k]==nums[k+1]) k--;
                }
            }
        }
        return ans;
    }
};