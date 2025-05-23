int maxFrequencyElements(int* nums, int numsSize) {
    int freq[101] = {0};
    for(int i=0;i<numsSize;i++){
        freq[nums[i]]++;
    }
    int max_freq = 0;
    int result = 0;
    for(int i=0;i<101;i++){
        if(freq[i]>max_freq){
            max_freq = freq[i];
            result = max_freq;
        }else if(freq[i]==max_freq){
            result += freq[i];
        }
    }
    return result;
}