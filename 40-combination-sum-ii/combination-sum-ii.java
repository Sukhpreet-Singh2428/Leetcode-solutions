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
        combinations(idx+1, sum, ans, ls, reqSum, arr, n);
        sum -= arr[idx];
        ls.remove(ls.size()-1);
        idx = upperBound(arr, idx, arr[idx], n);
        combinations(idx, sum, ans, ls, reqSum, arr, n);
    }
    public static int upperBound(int[] arr, int idx, int target, int n){
        int low = idx;
        int high = n-1;
        int ans = n;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid] <= target){
                low = mid+1;
            }
            else{
                ans = mid;
                high = mid-1;
            }
        }
        return ans;
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        Arrays.sort(candidates);
        combinations(0, 0, ans, ls, target, candidates, candidates.length);
        return ans;
    }
}