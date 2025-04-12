bool isMonotonic(int* nums, int numsSize) {
    int acending = 1, decending = 1;
    for(int i=0;i<numsSize-1;i++){
        if(nums[i]<nums[i+1]) decending = 0;
        if(nums[i]>nums[i+1]) acending = 0;
    }
    if(acending || decending){
        return true;
    }else{
        return false;
    }
}