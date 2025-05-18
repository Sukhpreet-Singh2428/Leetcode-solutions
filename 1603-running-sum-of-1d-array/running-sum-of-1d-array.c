/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* runningSum(int* nums, int numsSize, int* returnSize) {
    int* result = (int*)malloc(numsSize*sizeof(int));
    *returnSize = numsSize;
    int sum = nums[0];
    result[0] = sum;
    for(int i=1;i<numsSize;i++){
        sum = sum + nums[i];
        result[i] = sum;
    }
    return result;
}