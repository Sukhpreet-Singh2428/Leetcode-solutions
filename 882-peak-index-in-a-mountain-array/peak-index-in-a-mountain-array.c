int peakIndexInMountainArray(int* arr, int arrSize) {
    int low = 1;            //avoid arr[mid - 1] at index 0
    int high = arrSize-2;   //avoid arr[mid + 1] at last index
    while(low<=high){
        int mid = low + (high-low)/2;
        if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]) return mid;
        else if(arr[mid]>arr[mid-1]) low = mid + 1;
        else high = mid - 1;
    }
    return -1;
}