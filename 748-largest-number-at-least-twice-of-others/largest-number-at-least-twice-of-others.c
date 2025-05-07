int dominantIndex(int* nums, int numsSize) {
    int max = INT_MIN;
    int max_idx = -1;
    for(int i=0;i<numsSize;i++){
        if(nums[i]>max){
            max = nums[i];
            max_idx = i;
        }
    }
    for(int i=0;i<numsSize;i++){
        if(max<nums[i]*2 && nums[i]!=max) return -1;
    }
    return max_idx;
}