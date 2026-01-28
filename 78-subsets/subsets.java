class Solution {
    public static void subsequence(int idx, List<List<Integer>> ans, List<Integer> arr, int[] nums, int n){
        if(idx >= n){
            ans.add(new ArrayList<>(arr));
            return;
        }
        arr.add(nums[idx]);
        subsequence(idx+1, ans, arr, nums, n);
        arr.remove(arr.size()-1);
        subsequence(idx+1, ans, arr, nums, n);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        subsequence(0, ans, arr, nums,  nums.length);
        return ans;
    }
}