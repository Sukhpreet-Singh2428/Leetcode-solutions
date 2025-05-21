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
int heightChecker(int* heights, int heightsSize) {
    int* expected = (int*)malloc(heightsSize*sizeof(int));
    for(int i=0;i<heightsSize;i++){
        expected[i] = heights[i];
    }
    sort(expected,heightsSize);
    int count = 0;
    for(int i=0;i<heightsSize;i++){
        if(expected[i]!=heights[i]) count++;
    }
    free(expected);
    return count;
}