class Solution {
    public static boolean search(int[] arr, int target, int index){
        int n = arr.length;
        int low = 0;
        int high = index-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]==target) return true;
            else if(arr[mid] < target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return false;
    }
    public int findPairs(int[] nums, int k) {
        int n = nums.length;
        int cnt = 0;
        Arrays.sort(nums);
        if (k == 0) {
            int count = 0;
            for (int i = 1; i < n; i++) {
                if (nums[i] == nums[i-1]) {
                    count++;
                    while (i < n && nums[i] == nums[i-1]) i++;
                }
            }
            return count;
        }
        int[] arr = new int[n];
        arr[0] = nums[0];
        int index = 1;
        for(int i=1; i<n; i++){
            if(nums[i] != nums[i-1]){
                arr[index++] = nums[i];
            }
        }
        for(int i=0; i<index; i++){
            if(search(arr, arr[i]+k, index)){
                cnt++;
            }
        }
        return cnt;
    }
}