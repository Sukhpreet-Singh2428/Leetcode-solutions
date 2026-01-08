class Solution {
    public static int first(int[] arr){
        int low = 0;
        int high = arr.length-1;
        int ans = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid] < 0){
                ans = mid;
                high = mid-1;
            }
            else if(arr[mid] >= 0){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }
    public static int last(int[] arr){
        int low = 0;
        int high = arr.length-1;
        int ans = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid] < 0){
                ans = mid;
                low = mid+1;
            }
            else if(arr[mid] >= 0){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }
    public int countNegatives(int[][] grid) {
        int ans = 0;
        
        for(int i=0; i<grid.length; i++){
            int cnt = 0;
            int f = first(grid[i]);
            if(f==-1) continue;
            int l = last(grid[i]);
            cnt = (l-f)+1;

            ans += cnt;
        }

        return ans;
    }
}