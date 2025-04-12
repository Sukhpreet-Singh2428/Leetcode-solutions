void rotate(int* nums, int numsSize, int k) {
    void reverse(int* nums, int si, int ei){
        while(si<ei){
            int temp = nums[si];
            nums[si] = nums[ei];
            nums[ei] = temp;
            si++;
            ei--;       
        }
        return;
    }
    k = k%numsSize;
    reverse(nums,0,numsSize-1);
    reverse(nums,0,k-1);
    reverse(nums,k,numsSize-1);
}