/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* sortedSquares(int* nums, int numsSize, int* returnSize) {
    int* result = (int*)malloc(numsSize*sizeof(int));
    int left = 0, right = numsSize - 1;
    int index = numsSize - 1;
    while (left <= right) {
        int leftSq = nums[left] * nums[left];
        int rightSq = nums[right] * nums[right];
        if (leftSq > rightSq) {
            result[index--] = leftSq;
            left++;
        } else {
            result[index--] = rightSq;
            right--;
        }
    }
    *returnSize = numsSize;
    return result;
}