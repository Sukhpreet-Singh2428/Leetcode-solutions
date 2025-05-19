void sort(int* arr, int n){     // due to insertion sort O(n^2)
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
int minimumSum(int num) {
    int x[4];
    x[0] = num%10;
    num /= 10;
    x[1] = num%10;
    num /= 10;
    x[2] = num%10;
    num /= 10;
    x[3] = num%10;
    num /= 10;
    sort(x,4);
    return ((x[0] + x[1])*10 + x[2] + x[3]);
}