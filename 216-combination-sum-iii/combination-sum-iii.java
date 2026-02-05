class Solution {
    public static void subset(int idx, int sum, List<List<Integer>> ans, List<Integer> ls, int len, int totalSum, int[] nums, int n){
        if(sum == totalSum && ls.size()==len){
            ans.add(new ArrayList<>(ls));
            return;
        }
        if(idx==n){
            return;
        }
        if(ls.size()>len || sum > totalSum){
            return;
        }

        ls.add(nums[idx]);
        sum += nums[idx];
        subset(idx+1, sum, ans, ls, len, totalSum, nums, n);
        ls.remove(ls.size()-1);
        sum -= nums[idx];
        subset(idx+1, sum, ans, ls, len, totalSum, nums, n);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = new int[9];
        for(int i=0; i<9; i++){
            nums[i] = i+1;
        }

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        subset(0, 0, ans, ls, k, n, nums, nums.length);
        return ans;
    }
}