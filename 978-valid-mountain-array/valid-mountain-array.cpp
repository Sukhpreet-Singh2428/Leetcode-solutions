class Solution {
public:
    bool validMountainArray(vector<int>& arr) {
        int n = arr.size();
        if (n < 3) return false;
        int left = 0;
        int right = n - 1;
        while (left + 1 < n - 1 && arr[left] < arr[left + 1]) {
            left++;
        }
        while (right - 1 > 0 && arr[right - 1] > arr[right]) {
            right--;
        }
        return left == right;
    }
};