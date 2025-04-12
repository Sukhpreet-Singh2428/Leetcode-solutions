void sortColors(int* nums, int numsSize) {
    for(int i=1;i<numsSize;i++){
        int curr = nums[i];
        int prev = i-1;
        while(prev>=0 && nums[prev]>curr){
            nums[prev+1] = nums[prev];
            prev--;
        }
        nums[prev+1] = curr;
    }
}