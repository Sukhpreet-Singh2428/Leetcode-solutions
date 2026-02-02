class Solution {
    public static void uniqueSubsets(int idx, List<List<Integer>> ans, List<Integer> ls, int[] nums, int n){
        if(idx >= n){
            ans.add(new ArrayList<>(ls));
            return;
        }

        ls.add(nums[idx]);
        uniqueSubsets(idx+1, ans, ls, nums, n);
        ls.remove(ls.size()-1);
        idx = upperBound(nums, idx, nums[idx]);
        uniqueSubsets(idx, ans, ls, nums, n);
    }
    public static int upperBound(int[] nums, int idx, int target){
        int low = idx;
        int high = nums.length-1;
        int ans = nums.length;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid] <= target){
                low = mid+1;
            }
            else{
                ans = mid;
                high = mid-1;
            }
        }
        return ans;
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        Arrays.sort(nums);
        uniqueSubsets(0, ans, ls, nums, nums.length);
        return ans;
    }
}