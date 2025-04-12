int searchInsert(int* nums, int numsSize, int target) {
    int idx = 0;
    if(nums[numsSize-1]<target) return numsSize;
    for(int i=0;i<numsSize-1;i++){
        if(nums[i]==target) return i;
        if(nums[i]<=target && nums[i+1]>=target) return i+1;
        if(nums[i]<=target && nums[i+1]<=target) idx=i;
    }
    return idx;
}