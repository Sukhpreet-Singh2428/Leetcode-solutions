void sort(int* arr,int n){
    for(int i=1;i<n;i++){
        int curr = arr[i];
        int prev = i-1;
        while(prev>=0 && arr[prev]>curr){
            arr[prev+1] = arr[prev];
            prev--;
        }
        arr[prev+1] = curr;
    }
}
int missingNumber(int* nums, int numsSize) {
    sort(nums,numsSize);
    for(int i=0;i<numsSize;i++){
        if(nums[i]!=i) return i;
    }
    return numsSize;
}