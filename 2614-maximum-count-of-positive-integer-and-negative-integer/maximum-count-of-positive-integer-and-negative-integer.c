int maximumCount(int* nums, int numsSize) {
    int count1=0,count2=0;
    for(int i=0;i<numsSize;i++){
        if(nums[i]>0) count1++;
        if(nums[i]<0) count2++;
    }
    if(count1>=count2) return count1;
    else return count2;
}