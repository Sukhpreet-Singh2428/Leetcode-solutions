int findNumbers(int* nums, int numsSize) {
    int count = 0;
    for(int i=0;i<numsSize;i++){
        int check = 0;
        int n = nums[i];
        while(n){
            check++;
            n = n/10;
        }
        if(check%2==0) count++;
    }
    return count;
}