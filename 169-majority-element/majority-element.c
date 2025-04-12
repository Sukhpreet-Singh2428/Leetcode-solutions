int majorityElement(int* nums, int numsSize) {
        for(int i=0;i<numsSize;i++){
        int count = 0;
        int alreadycounted = 0;
        int idx = 0;
        for(int k=0;k<i;k++){
            if(nums[i]==nums[k]){
                alreadycounted=1;
                break;
            }
        }
        if(alreadycounted) continue;
        for(int j=0;j<numsSize;j++){
            if(nums[i]==nums[j]){
                count++;
                idx = i;
            }
        }
        if(count>(numsSize/2)){
            return nums[i];
        }
    }
    return -1;
}