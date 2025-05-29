/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* getConcatenation(int* nums, int numsSize, int* returnSize) {
    int* result = (int*)malloc(2*numsSize*sizeof(int));
    int index = 0;
    for(int i=0;i<numsSize;i++){
        result[index++] = nums[i];
    }
    for(int i=0;i<numsSize;i++){
        result[index++] = nums[i];
    }
    *returnSize = index;
    return result;
}