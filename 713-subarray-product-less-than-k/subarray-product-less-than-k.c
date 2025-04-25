int numSubarrayProductLessThanK(int* nums, int numsSize, int k) {
    int count = 0;
    for(int i=0;i<numsSize;i++){
        long long prod = 1;
        for(int j=i;j<numsSize;j++){
            prod = prod*nums[j];
            if(prod<k) count++;
            else break;  
        }
    }
    return count;
}