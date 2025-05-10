int thirdMax(int* nums, int numsSize) {
    long max=LONG_MIN,smax=LONG_MIN,tmax=LONG_MIN;   //use long : LONG_MIN bcz in testcase array 
    for(int i=0;i<numsSize;i++){                     //contains an element with value of INT_MIN
        if(max<nums[i]){
            tmax = smax;
            smax = max;
            max = nums[i];
        }else if(smax<nums[i] && nums[i]!=max){
            tmax = smax;
            smax = nums[i];
        }else if(tmax<=nums[i] && nums[i]!=smax && nums[i]!=max && numsSize>2){
            tmax = nums[i];
        }
    }
    if(tmax==LONG_MIN) return max;
    else return tmax;
}