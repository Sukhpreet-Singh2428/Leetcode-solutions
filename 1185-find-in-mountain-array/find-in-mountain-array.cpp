/**
 * // This is the MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * class MountainArray {
 *   public:
 *     int get(int index);
 *     int length();
 * };
 */

class Solution {
public:
    int peakIndex(MountainArray &mountainArr){
        int n = mountainArr.length();
        int low = 1;
        int high = n-2;
        while(low<=high){
            int mid = low + (high-low)/2;
            int midVal = mountainArr.get(mid);
            int leftVal = mountainArr.get(mid - 1);
            int rightVal = mountainArr.get(mid + 1);

            if (midVal > leftVal && midVal > rightVal) return mid;
            else if (midVal > leftVal) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
    int ascHalf(int target, MountainArray &mountainArr, int low, int high){
        while(low<=high){
            int mid = low + (high-low)/2;
            int midVal = mountainArr.get(mid);
            if(midVal == target){
                return mid;
            }
            else if(midVal < target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }
    int desHalf(int target, MountainArray &mountainArr, int low, int high){
        while(low<=high){
            int mid = low + (high-low)/2;
            int midVal = mountainArr.get(mid);
            if(midVal == target){
                return mid;
            }
            else if(midVal < target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }
    int findInMountainArray(int target, MountainArray &mountainArr) {
        int n = mountainArr.length();
        int peak = peakIndex(mountainArr);
        if(mountainArr.get(peak) == target) return peak;

        int firstHalf = ascHalf(target, mountainArr, 0, peak);
        if(firstHalf != -1){
            return firstHalf;
        }
        int secondHalf = desHalf(target, mountainArr, peak+1, n-1);
        return secondHalf;
    }
};