class Solution {
    public boolean binarySearch(int[] matrix, int target){
        int low = 0;
        int high = matrix.length-1;

        while(low<=high){
            int mid = low + (high-low)/2;
            if(matrix[mid] == target) return true;
            else if(matrix[mid] < target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;

        for(int i=0; i<n; i++){
            if(matrix[i][0]<=target && target<=matrix[i][matrix[i].length-1]){
                if(binarySearch(matrix[i], target)){
                    return true;
                }
            }
        }

        return false;
    }
}