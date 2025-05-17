/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* findDuplicates(int* nums, int numsSize, int* returnSize) {
    int freq[100001] = {0};
    for(int i=0;i<numsSize;i++){
        freq[nums[i]]++;
    }
    int* result = (int*)malloc(numsSize*sizeof(int));
    int j = 0;
    for(int i=0;i<100001;i++){
        if(freq[i]>1) result[j++] = i;
    }
    *returnSize = j;
    return result;
}