class Solution {
public:
    bool find(vector<int>& arr, int target, int i){
        int n = arr.size();
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid] == target && mid != i) return true;
            else if(arr[mid] < target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return false;
    }
    bool checkIfExist(vector<int>& arr) {
        int n = arr.size();
        sort(arr.begin(), arr.end());
        for(int i=0; i<n; i++){
            if(find(arr, 2*arr[i], i)) return true;
        }
        return false;
    }
};