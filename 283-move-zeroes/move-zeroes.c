void swap(int* i,int* j){
    int temp = *i;
    *i = *j;
    *j = temp;
    return;
}
void moveZeroes(int* nums, int numsSize) {
    int i=0;
    int j=0;
    while(j<numsSize){
        if(nums[j]==0){
            j++;
        }
        else{
            swap(&nums[i],&nums[j]);
            i++;
            j++;
        }
    }
    return;
}