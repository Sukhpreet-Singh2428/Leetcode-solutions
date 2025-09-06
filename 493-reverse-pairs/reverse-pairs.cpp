class Solution {
public:
    // int cnt = 0;
    void merge(vector<int>& nums, int low, int mid, int high){
        int left = low;
        int right = mid+1;
        vector<int> temp;
        while(left<=mid && right<=high){
            if(nums[left]<=nums[right]){
                temp.push_back(nums[left]);
                left++;
            }
            else{
                temp.push_back(nums[right]);
                right++;
            }
        }
        while(left<=mid){
            temp.push_back(nums[left]);
            left++;
        }
        while(right<=high){
            temp.push_back(nums[right]);
            right++;
        }
        for(int i=low; i<=high; i++){
            nums[i] = temp[i-low];
        }
    }
    int CountPairs(vector<int>& nums, int low, int mid, int high){
        int cnt = 0;
        int right = mid+1;
        for(int i=low; i<=mid; i++){
            while(right<=high && (long long)nums[i] > 2LL*(long long)nums[right]) right++;
            cnt += (right - (mid+1));
        }
        return cnt;
    }
    int mergeSort(vector<int>& nums, int low, int high){
        int cnt = 0;
        if(low>=high) return cnt;
        int mid = low + (high-low)/2;
        cnt += mergeSort(nums,low,mid);
        cnt += mergeSort(nums,mid+1,high);
        cnt += CountPairs(nums, low, mid, high);
        merge(nums, low, mid, high);
        return cnt;
    }
    int reversePairs(vector<int>& nums) {
        int n = nums.size();
        return mergeSort(nums, 0, n-1);
    }
};