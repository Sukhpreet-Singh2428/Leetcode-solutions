int getCommon(int* nums1, int nums1Size, int* nums2, int nums2Size) {
    // for(int i=0;i<nums1Size;i++){
    //     for(int j=0;j<nums2Size;j++){
    //         if(nums1[i]==nums2[j]){
    //             return nums1[i];
    //         }
    //     }
    // }
    // return -1;
    int i=0,j=0;
    while(i<nums1Size && j<nums2Size){
        if(nums1[i]==nums2[j]) return nums1[i];
        else if(nums1[i]<nums2[j]) i++;
        else j++;
    }
    return -1;
}