class Solution {
public:
    void merge(vector<int>& arr, int low, int mid, int high){
        vector<int> temp;
        int i = low;
        int j = mid+1;
        while(i<=mid && j<=high){
            if(arr[i]<=arr[j]){
                temp.push_back(arr[i]);
                i++;
            }
            else{
                temp.push_back(arr[j]);
                j++;
            }
        }
        while(i<=mid){
            temp.push_back(arr[i]);
            i++;
        }
        while(j<=high){
            temp.push_back(arr[j]);
            j++;
        }
        for(int x=low; x<=high; x++){
            arr[x] = temp[x-low];
        }
    }
    void mergeSort(vector<int>& arr, int low, int high){
        if(low>=high) return;
        int mid = low + (high-low)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }
    int firstMissingPositive(vector<int>& nums) {
        mergeSort(nums, 0, nums.size()-1);
        int firstMissing = 1;
        for(int i=0; i<nums.size(); i++){
            if(nums[i]<firstMissing) continue;
            if(firstMissing != nums[i]) return firstMissing;
            firstMissing++;
        }
        return firstMissing;
    }
};