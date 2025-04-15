/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* searchRange(int* nums, int numsSize, int target, int* returnSize) {
    int first = -1, last = -1;
    for (int i = 0; i < numsSize; i++) {
        if (nums[i] == target) {
            if (first == -1) {
                first = i;
            }
            last = i;
        }
    }
    // Allocate space for 2 integers
    int* result = (int*)malloc(2 * sizeof(int));
    result[0] = first;
    result[1] = last;
    // Set the return size to 2 (since we're returning 2 elements)
    *returnSize = 2;
    return result;
}