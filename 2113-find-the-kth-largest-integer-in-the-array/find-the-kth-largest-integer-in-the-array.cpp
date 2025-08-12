class Solution {
public:
    static bool compare(string& a, string & b){
        if(a.size() != b.size()){
            return a.size() < b.size();
        }
        return a < b;
    }
    string kthLargestNumber(vector<string>& nums, int k) {
        int n = nums.size();
        sort(nums.begin(), nums.end(), compare);
        return nums[n-k];
    }
};
// sorts lexicographically (dictionary order), not by numeric value.
// This means "100" will come before "20" because '1' < '2' comparing as strings.