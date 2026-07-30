class Solution {
    public boolean binarySearch(int[] arr, int target){
        int low = 0;
        int high = arr.length-1;

        while(low<=high){
            int mid = low + (high-low)/2;

            if(arr[mid] == target) return true;
            else if(arr[mid] < target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        return false;
    }
    public int binarySearchFunc(int[][] matrix, int target){
        int low = 0;
        int high = matrix.length-1;
        int ans = -1;

        while(low<=high){
            int mid = low + (high-low)/2;

            if(matrix[mid][0]<=target){
                ans = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        return ans;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;

        int row = binarySearchFunc(matrix, target);
        if(row==-1) return false;

        return binarySearch(matrix[row], target);
    }
}