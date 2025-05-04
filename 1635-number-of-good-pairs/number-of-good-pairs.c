int numIdenticalPairs(int* nums, int numsSize) {
    int count = 0;
    for(int i=0;i<numsSize;i++){
        for(int j=numsSize-1;j>=i;j--){
            if((nums[i]==nums[j]) && i<j) count++;
        }
    }
    return count;
}