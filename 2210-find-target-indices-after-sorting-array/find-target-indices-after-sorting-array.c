/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
void sort(int* arr, int n){
    for(int i=1;i<n;i++){
        int curr = arr[i];
        int prev = i-1;
        while(prev>=0 && arr[prev]>curr){
            arr[prev+1] = arr[prev];
            prev--;
        }
        arr[prev+1] = curr;
    }
}
int* targetIndices(int* nums, int numsSize, int target, int* returnSize) {
    int* result = (int*)malloc(numsSize*sizeof(int));
    int index = 0;
    sort(nums,numsSize);
    for(int i=0;i<numsSize;i++){
        if(nums[i]==target) result[index++] = i;
    }
    *returnSize = index;
    return result;
}