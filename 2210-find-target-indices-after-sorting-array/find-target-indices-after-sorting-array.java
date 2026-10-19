class Solution {
    public int firstOccurance(int[] nums, int target){
        int low = 0;
        int high= nums.length-1;
        int ans = -1;

        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                ans = mid;
                high = mid-1;
            }
            else if(nums[mid] < target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        return ans;
    }
    public int lastOccurance(int[] nums, int target){
        int low = 0;
        int high= nums.length-1;
        int ans = -1;

        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                ans = mid;
                low = mid+1;
            }
            else if(nums[mid] < target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        return ans;
    }
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);

        int f = firstOccurance(nums, target);
        if(f==-1) return new ArrayList<>();
        int l = lastOccurance(nums, target);

        List<Integer> ls = new ArrayList<>();
        for(int i=f; i<=l; i++){
            ls.add(i);
        }

        return ls;
    }
}