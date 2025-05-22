int mostFrequentEven(int* nums, int numsSize) {
    int freq[100001] = {0};
    for(int i=0;i<numsSize;i++){
        if(nums[i]%2==0) freq[nums[i]]++;
    }
    int max_freq = 0;
    int num = -1;
    for(int i=0;i<100001;i++){
        if(freq[i]>max_freq){
            max_freq = freq[i];
            num = i;
        }
    }
    return num;
}