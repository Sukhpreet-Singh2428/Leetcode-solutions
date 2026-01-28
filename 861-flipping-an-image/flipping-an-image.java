class Solution {
    public static void reverse(int[] arr){
        int i = 0;
        int j = arr.length-1;
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            arr[i] = arr[i]==0 ? 1 : 0;
            arr[j] = arr[j]==0 ? 1 : 0;
            i++;
            j--;
        }
        if(arr.length%2==1){
            arr[i] = arr[i]==0 ? 1 : 0;
        }
    }
    public int[][] flipAndInvertImage(int[][] image) {
        for(int i=0; i<image.length; i++){
            reverse(image[i]);
        }

        return image;
    }
}