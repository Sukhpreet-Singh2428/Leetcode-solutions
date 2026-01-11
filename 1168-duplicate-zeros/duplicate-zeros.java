class Solution {
    public static void modify(int[] arr, int i, int j){
        int n = arr.length;
        int next = 0;
        while(i<n){
            if(i==j){
                next = arr[i];
                arr[i] = 0;
                i++;
            }
            else{
                int temp = arr[i];
                arr[i] = next;
                next = temp;
                i++;
            }
        }
    }
    public void duplicateZeros(int[] arr) {
        int n = arr.length;

        int i=0;
        while(i<n){
            if(arr[i]==0){
                modify(arr, i+1, i+1);
                i++;
            }
            i++;
        }
    }
}