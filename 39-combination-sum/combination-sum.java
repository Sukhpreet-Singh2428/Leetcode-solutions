class Solution {
    public static void combinations(int idx, int sum, List<List<Integer>> ans, List<Integer> ls, int reqSum, int[] arr, int n){
        if(sum == reqSum){
            ans.add(new ArrayList<>(ls));
            return;
        }
        if(sum > reqSum){
            return;
        }
        if(idx==n){
            return;
        }
        ls.add(arr[idx]);
        sum += arr[idx];
        combinations(idx, sum, ans, ls, reqSum, arr, n);
        sum -= arr[idx];
        ls.remove(ls.size()-1);
        combinations(idx+1, sum, ans, ls, reqSum, arr, n);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        combinations(0, 0, ans, ls, target, candidates, candidates.length);
        return ans;
    }
}